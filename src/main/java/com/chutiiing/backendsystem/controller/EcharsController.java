package com.chutiiing.backendsystem.controller;

import com.chutiiing.backendsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echars")
public class EcharsController {

    @Autowired
    private StudentService studentService;

//    //返回各个学院的情况
//    @GetMapping("/bar")
//    public Result academyResult() {
//
//    }

}
