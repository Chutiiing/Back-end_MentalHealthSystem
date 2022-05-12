package com.chutiiing.backendsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chutiiing.backendsystem.entity.Teacher;
import com.chutiiing.backendsystem.mapper.TeacherMapper;
import org.springframework.stereotype.Service;


@Service
public class TeacherService extends ServiceImpl<TeacherMapper, Teacher> {

    //判断用户名密码是否正确
    public boolean login(Teacher teacher) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",teacher.getUsername());
        queryWrapper.eq("password",teacher.getPassword());
        Teacher temp = getOne(queryWrapper);
        return temp != null;
    }

}
