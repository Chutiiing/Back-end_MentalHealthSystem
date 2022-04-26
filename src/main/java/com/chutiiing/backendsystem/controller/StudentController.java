package com.chutiiing.backendsystem.controller;

import com.chutiiing.backendsystem.entity.Academy;
import com.chutiiing.backendsystem.entity.Students;
import com.chutiiing.backendsystem.mapper.StudentsMapper;
import com.chutiiing.backendsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentsMapper studentsMapper;
    @Autowired
    private StudentService studentService;

    //查询全部数据
    @GetMapping
    public List<Students> findAll() {
        return studentsMapper.findAll();
    }

    //查询总人数
    @GetMapping("/stuCount")
    public Map<String,Object> studentNumTotal() {
        Map<String,Object> res = new HashMap<>();
        Integer total = studentsMapper.stuTotalNum();      //查询总人数
        Integer danger = studentsMapper.stuDangerNum();    //查询危险的人数
        res.put("total",total);
        res.put("danger",danger);
        return res;
    }

    //查询各个学院的情况
    @GetMapping("/academy")
    public Map<String,Object> academyState() {
        Map<String,Object> map = new HashMap<>();
        List<Academy> res = studentsMapper.academyResult();

        //学院名称
        ArrayList<String> name = new ArrayList<>();
        for (int i = 0; i < res.size(); i++){
            name.add(res.get(i).getAcademy());
        }
        map.put("y",name);    //纵坐标记录学院名称

        //各个学院总人数
        ArrayList<Integer> total = new ArrayList<>();
        for (int i = 0; i < res.size(); i++){
            total.add(res.get(i).getTotal());
        }
        map.put("total",total);

        //各个学院危险人数
        ArrayList<Integer> danger = new ArrayList<>();
        for (int i = 0; i < res.size(); i++){
            danger.add(res.get(i).getDanger());
        }
        map.put("danger",danger);
        return map;
    }

    //插入数据
    //外部传入的student对象作为参数
    //"RequestBody"可以把前端传来的jason数据转换成java对象
    @PostMapping("/insert")
    public Integer insert(@RequestBody Students students) {
        return studentsMapper.insert(students);
    }

    //更新某一行
    @PostMapping("/update")
    public Integer Update(@RequestBody Students students) { return studentsMapper.update(students); }

    //删除某一行
    @DeleteMapping("/del/{sno}")
    public Integer delete(@PathVariable String sno){
        return studentsMapper.deleteBySno(sno);
    }

    //批量删除（My-Batis plus)
    @PostMapping("/batch")
    public boolean deleteBatch(@RequestBody List<String> snos){
        return studentService.removeByIds(snos);
    }

    // 分页查询
    // 接口路径：/students/page?pageNum=1&pageSize=10&sno=221801438
    // @RequestParam接受
    // limit第一个参数 = (pageNum - 1) * pageSize
    // limit第二个参数 = pageSize
    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam String sno,
                                       @RequestParam String name,
                                       @RequestParam String academy,
                                       @RequestParam String grade,
                                       @RequestParam String state) {
        pageNum = (pageNum - 1) * pageSize;
        sno  = "%" + sno + "%";    //学号模糊查询
        name  = "%" + name + "%";    //姓名模糊查询
        academy  = "%" + academy + "%";    //学院模糊查询
        grade  = "%" + grade + "%";    //年级模糊查询
        state  = "%" + state + "%";    //心理状态模糊查询
        List<Students> data = studentsMapper.selectPage(pageNum,pageSize,sno,name,academy,grade,state);
        Integer total = studentsMapper.selectTotalNum(sno,name,academy,grade,state);
        Map<String,Object> res = new HashMap<>();
        res.put("total",total);
        res.put("data",data);
        return res;
    }
}
