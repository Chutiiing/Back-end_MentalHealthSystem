package com.chutiiing.backendsystem.controller;

import com.chutiiing.backendsystem.entity.Teacher;
import com.chutiiing.backendsystem.mapper.TeacherMapper;
import com.chutiiing.backendsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherMapper teacherMapper;

    @PostMapping("/login")
    public boolean login(@RequestBody Teacher teacher){
        return teacherService.login(teacher);
    }

    @GetMapping("/search/{tno}")
    public Teacher find(@PathVariable String tno){
        return teacherMapper.find(tno);
    }

    @PostMapping("/insert")
    public Integer insert(@RequestBody Teacher teacher) {
        return teacherMapper.insert(teacher);
    }
}
