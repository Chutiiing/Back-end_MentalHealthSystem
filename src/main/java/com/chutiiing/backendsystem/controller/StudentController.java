package com.chutiiing.backendsystem.controller;

import com.chutiiing.backendsystem.entity.Students;
import com.chutiiing.backendsystem.mapper.StudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
public class StudentController {

    @Autowired
    private StudentsMapper studentsMapper;

    @GetMapping("/")
    public List<Students> index() {
        return studentsMapper.findAll();
    }
}
