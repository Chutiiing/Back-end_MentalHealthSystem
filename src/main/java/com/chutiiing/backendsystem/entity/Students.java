package com.chutiiing.backendsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Students {
    private String sno;
    private String name;
    @JsonIgnore
    private String password;
    private String sex;
    private String academy;
    private String major;
    private int grade;
    private  String state;
}
