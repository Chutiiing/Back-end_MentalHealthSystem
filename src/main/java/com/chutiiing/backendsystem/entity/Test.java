package com.chutiiing.backendsystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "test_name")
public class Test {
    @TableId
    private Integer tableid;
    private String title;
    private String introduction;
    private String admin;
    private String time;
}
