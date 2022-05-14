package com.chutiiing.backendsystem.controller;

import com.chutiiing.backendsystem.mapper.StudentsMapper;
import com.chutiiing.backendsystem.mapper.TestHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/testHistory")
public class TestHistoryController {

    @Autowired
    private TestHistoryMapper historyMapper;
    @Autowired
    private StudentsMapper studentsMapper;

    //查询人数
    @GetMapping("/count/{title}")
    public Map<String,Object> finishNumTotal(@PathVariable String title) {
        Map<String,Object> res = new HashMap<>();
        Integer total = studentsMapper.stuTotalNum();      //查询总人数
        Integer finish = historyMapper.countNum(title);    //查询已填写的人数
        res.put("total",total);
        res.put("finish",finish);
        return res;
    }
}
