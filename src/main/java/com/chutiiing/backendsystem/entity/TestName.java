package com.chutiiing.backendsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "test_name")
public class TestName {
    private String title;
}
