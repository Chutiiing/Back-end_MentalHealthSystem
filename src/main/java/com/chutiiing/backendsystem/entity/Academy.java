package com.chutiiing.backendsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "students")
public class Academy {
    private String academy;   //学院名称
    private  Integer total;     //学院人数
    private  Integer danger;
}
