package com.chutiiing.backendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chutiiing.backendsystem.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    //查询
    @Select("select * from teacher where tno = #{tno}")
    Teacher find(@Param("tno") String tno);

    //插入
    @Insert("INSERT into teacher(tno, username, password, sex, introduction, " +
            "phone, room) VALUES (#{tno}, #{username}, #{password}, #{sex}, #{introduction}, #{phone}, #{room})")
    int insert(Teacher teacher);
}
