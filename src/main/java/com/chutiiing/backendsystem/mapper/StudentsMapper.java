package com.chutiiing.backendsystem.mapper;

import com.chutiiing.backendsystem.entity.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentsMapper {

    @Select("select * from students")
    List<Students> findAll();
}
