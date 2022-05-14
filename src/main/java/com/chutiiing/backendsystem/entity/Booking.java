package com.chutiiing.backendsystem.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "booking")
public class Booking {
    @TableId
    private Integer id;
    private String time;
    private String tno;
    private String isbooking;
    private String sno;
    private String room;

}
