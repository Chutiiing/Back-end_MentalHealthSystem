package com.chutiiing.backendsystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tips")
public class Tips {
    @TableId
    private Integer id;
    private String content;
}
