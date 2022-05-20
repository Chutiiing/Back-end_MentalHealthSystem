package com.chutiiing.backendsystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "collect")
public class Collect {
    @TableId
    private Integer id;
    private String sno;
    private Integer tipsId;
}
