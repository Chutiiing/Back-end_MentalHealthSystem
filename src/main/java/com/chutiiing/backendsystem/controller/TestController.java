package com.chutiiing.backendsystem.controller;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.chutiiing.backendsystem.entity.Test;
import com.chutiiing.backendsystem.entity.TestName;
import com.chutiiing.backendsystem.entity.TestQuestion;
import com.chutiiing.backendsystem.mapper.TestMapper;
import com.chutiiing.backendsystem.mapper.TestQuestionMapper;
import com.chutiiing.backendsystem.service.TestQuestionService;
import com.chutiiing.backendsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestMapper testMapper;
    @Autowired
    private TestService testService;
    @Autowired
    private TestQuestionMapper testQuestionMapper;
    @Autowired
    private TestQuestionService testQuestionService;

    //查询全部数据
    @GetMapping("/findAll")
    public List<Test> findAll() {
       return testMapper.findAll();
    }

    //分页查询
    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam String title) {
        pageNum = (pageNum - 1) * pageSize;
        title  = "%" + title + "%";    //标题模糊查询
        List<Test> data = testMapper.selectPage(pageNum,pageSize,title);
        Integer total = testMapper.selectTotalNum(title);
        Map<String,Object> res = new HashMap<>();
        res.put("total",total);
        res.put("data",data);
        return res;
    }

    //删除量表
    @DeleteMapping("/del/{tableid}")
    public Integer delete(@PathVariable String tableid){
        return testMapper.deleteById(tableid);
    }

    //量表导入
    @PostMapping("/import")
    public Boolean imp(MultipartFile file,@RequestParam String admin) throws Exception {

        //导入量表
        Test test = new Test();
        //获取发布人信息
        test.setAdmin(admin);
        //获取文件名且不加后缀
        String fileName = file.getResource().getFilename();
        String prefix=fileName.substring(fileName.lastIndexOf(".")+1);//不带后缀名
        int num=prefix.length()+1;//得到后缀名长度
        String fileOtherName=fileName.substring(0, fileName.length()-num);//得到文件名，去掉了后缀
        test.setTitle(fileOtherName);

        //量表已经存在
        if(testService.testExists(test)){
            return false;
        }
        //量表不存在
        else {
            //读出文件流
            InputStream inputStream = file.getInputStream();
            ExcelReader reader = ExcelUtil.getReader(inputStream);
            //通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
            List<TestQuestion> list = reader.readAll(TestQuestion.class);
            //获取量表id和简介
            test.setTableid(list.get(0).getTableid());
            test.setIntroduction(list.get(0).getIntroduction());

            //创建新量表
            int flag1 = testMapper.insert(test);
            //将问题列表插入
            Boolean flag2 = testQuestionService.saveBatch(list);

            return flag1 != 0 && flag2;
        }
    }

    //查询量表名字
    @GetMapping("/findName")
    public Map<String,Object> findName() {
        Map<String, Object> map = new HashMap<>();
        List<TestName> res = testMapper.findName();

        //学院名称
        ArrayList<String> title = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            title.add(res.get(i).getTitle());
        }
        map.put("title", title);    //返回量表名称数组
        return map;
    }
}

