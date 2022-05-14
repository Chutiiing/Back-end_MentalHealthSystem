package com.chutiiing.backendsystem.controller;


import com.chutiiing.backendsystem.entity.Test;
import com.chutiiing.backendsystem.mapper.TestMapper;
import com.chutiiing.backendsystem.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}

