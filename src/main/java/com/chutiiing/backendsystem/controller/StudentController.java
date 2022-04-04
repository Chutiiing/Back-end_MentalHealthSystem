package com.chutiiing.backendsystem.controller;

import com.chutiiing.backendsystem.entity.Students;
import com.chutiiing.backendsystem.mapper.StudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //插入数据，外部传入的student对象作为参数
    @PostMapping
    public Integer insert(@RequestBody Students students) {
        return studentsMapper.insert(students);
    }

//    //更新某一行
//    @PostMapping
//    public Integer Update(@RequestBody Students students) {
//        return studentsMapper.update(students);
//    }

    //删除某一行
    @DeleteMapping("/{sno}")
    public Integer delete(@PathVariable String sno){
        return studentsMapper.deleteBySno(sno);
    }
}
