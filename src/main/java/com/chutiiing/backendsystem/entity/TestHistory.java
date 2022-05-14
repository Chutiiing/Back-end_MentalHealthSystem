package com.chutiiing.backendsystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "test_history")
public class TestHistory {
    @TableId
    private Integer id;
    private String sno;
    private String title;
    private String result;
    private String date;
}
