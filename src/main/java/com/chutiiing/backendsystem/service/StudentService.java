package com.chutiiing.backendsystem.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chutiiing.backendsystem.entity.Students;
import com.chutiiing.backendsystem.mapper.StudentsMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends ServiceImpl<StudentsMapper, Students> {

}
