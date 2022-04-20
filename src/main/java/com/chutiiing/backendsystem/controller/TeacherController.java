package com.chutiiing.backendsystem.controller;

import com.chutiiing.backendsystem.entity.Teacher;
import com.chutiiing.backendsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login")
    public boolean login(@RequestBody Teacher teacher){
        return teacherService.login(teacher);
    }
}
