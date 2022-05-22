package com.chutiiing.backendsystem.controller;

import com.chutiiing.backendsystem.entity.TestHistory;
import com.chutiiing.backendsystem.entity.TestRecord;
import com.chutiiing.backendsystem.mapper.StudentsMapper;
import com.chutiiing.backendsystem.mapper.TestHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    //插入数据
    @PostMapping("/insert")
    public Boolean insert(@RequestBody TestHistory testHistory) {
        return historyMapper.insert(testHistory) == 1;
    }

    //查询量表测评记录
    @GetMapping("/find/{sno}")
    public List<TestRecord> find(@PathVariable String sno){
        return historyMapper.findList(sno);
    }
}
