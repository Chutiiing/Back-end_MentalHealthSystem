package com.chutiiing.backendsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chutiiing.backendsystem.entity.Test;
import com.chutiiing.backendsystem.mapper.TestMapper;
import org.springframework.stereotype.Service;

@Service
public class TestService extends ServiceImpl<TestMapper, Test> {
    //判断文件是否导入过
    //返回true表示已经存在
    public boolean testExists(Test test) {
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tableid",test.getTableid());
        Test temp = getOne(queryWrapper);
        return temp != null;
    }
}
