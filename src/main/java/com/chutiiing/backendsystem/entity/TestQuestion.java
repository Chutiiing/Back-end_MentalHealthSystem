package com.chutiiing.backendsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@TableName(value = "test")
@ToString
public class TestQuestion {
    private Integer id;
    private Integer tableid;
    private String content;
    private Integer flag;               //标记是正面还是负面（0表示消极，1表示积极）
    private String introduction;
}
