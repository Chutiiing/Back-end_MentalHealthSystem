package com.chutiiing.backendsystem.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "teacher")
public class Teacher {
    @TableId
    private String username;
    private String password;
}
