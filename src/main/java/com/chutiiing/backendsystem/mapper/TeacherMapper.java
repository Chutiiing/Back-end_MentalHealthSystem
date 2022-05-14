package com.chutiiing.backendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chutiiing.backendsystem.entity.Teacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    //查询
    @Select("select * from teacher where tno = #{tno}")
    Teacher find(@Param("tno") String tno);

    //插入
    @Insert("INSERT into teacher(tno, username, password, sex, introduction, " +
            "phone, room) VALUES (#{tno}, #{username}, #{password}, #{sex}, #{introduction}, #{phone}, #{room})")
    int insert(Teacher teacher);

    //更新
    @Update("update teacher set tno = #{tno}, username = #{username}, password = #{password}, sex = #{sex}, introduction = #{introduction}, " +
            "phone = #{phone}, room = #{room} where tno = #{tno}")
    Integer update(Teacher teacher);
}
