package com.chutiiing.backendsystem.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chutiiing.backendsystem.entity.TestQuestion;
import com.chutiiing.backendsystem.mapper.TestQuestionMapper;
import org.springframework.stereotype.Service;

@Service
public class TestQuestionService  extends ServiceImpl<TestQuestionMapper, TestQuestion> {
}
