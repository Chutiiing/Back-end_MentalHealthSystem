package com.chutiiing.backendsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chutiiing.backendsystem.entity.Students;
import com.chutiiing.backendsystem.mapper.StudentsMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends ServiceImpl<StudentsMapper, Students> {
    //判断用户名密码是否正确
    public boolean login(Students students) {
        QueryWrapper<Students> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sno",students.getSno());
        queryWrapper.eq("password",students.getPassword());
        Students temp = getOne(queryWrapper);
        System.out.println(temp);
        return temp != null;
    }
}
