package com.chutiiing.backendsystem.mapper;

import com.chutiiing.backendsystem.entity.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentsMapper {

    //查询
    @Select("select * from students")
    List<Students> findAll();

    //插入
    @Insert("INSERT into students(sno, name, password, sex, academy, major, grade) VALUES (#{sno}, #{name}," +
            "#{password}, #{sex}, #{academy}, #{major}, #{grade})")
    int insert(Students students);

    //更新
    @Update("update students set sno = #{sno}, name = #{name}, sex = #{sex}, academy = #{academy}, " +
            "major = #{major}, grade = #{grade} where sno = #{sno}")
    int update(Students students);

    //删除
    @Delete("delete from students where sno = #{sno}")
    int deleteBySno(@Param("sno") String sno);
}
