package com.chutiiing.backendsystem.controller;

import com.chutiiing.backendsystem.entity.Students;
import com.chutiiing.backendsystem.mapper.StudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentsMapper studentsMapper;

    //查询全部数据
    @GetMapping
    public List<Students> findAll() {
        return studentsMapper.findAll();
    }

    //插入数据
    // 外部传入的student对象作为参数
    @PostMapping("/insert")
    public Integer insert(@RequestBody Students students) {
        return studentsMapper.insert(students);
    }

    //更新某一行
    @PostMapping("/update")
    public Integer Update(@RequestBody Students students) {
        return studentsMapper.update(students);
    }

    //删除某一行
    @DeleteMapping("/{sno}")
    public Integer delete(@PathVariable String sno){
        return studentsMapper.deleteBySno(sno);
    }

    // 分页查询
    // 接口路径：/students/page?pageNum=1&pageSize=10
    // @RequestParam接受
    // limit第一个参数 = (pageNum - 1) * pageSize
    // limit第二个参数 = pageSize
    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<Students> data = studentsMapper.selectPage(pageNum,pageSize);
        Integer total = studentsMapper.selectTotalNum();
        Map<String,Object> res = new HashMap<>();
        res.put("total",total);
        res.put("data",data);
        return res;
    }
}
