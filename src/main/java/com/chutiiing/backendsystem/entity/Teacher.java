package com.chutiiing.backendsystem.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "teacher")
public class Teacher {
    @TableId
    private String tno;
    private String username;
    private String password;
    private String sex;
    private String introduction;
    private String phone;
    private String room;
}
