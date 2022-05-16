package com.chutiiing.backendsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@TableName(value = "test")
@ToString
public class TestQuestion {
    private Integer tableid;
    private String content;
    private String introduction;
}
