package com.chutiiing.backendsystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "students")
public class Students {
    @TableId
    private String sno;
    private String name;
    private String password;
    private String sex;
    private String academy;
    private String major;
    private int grade;
    private  String state;
}
