package com.chutiiing.backendsystem.mapper;

import com.chutiiing.backendsystem.entity.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentsMapper {

    //查询
    @Select("select * from students")
    List<Students> findAll();

    //分页查询
    @Select("select * from students where sno like #{sno} and name like #{name} and major like #{major}" +
            "and grade like #{grade} and state like #{state} limit #{pageNum}, #{pageSize}")
    List<Students> selectPage(Integer pageNum, Integer pageSize, String sno, String name,
                              String major, String grade, String state);

    //查询总条数
    @Select("select count(*) from students where sno like #{sno} and name like #{name} and major like #{major}" +
            "and grade like #{grade} and state like #{state}")
    Integer selectTotalNum(String sno, String name,
                           String major, String grade, String state);

    //插入
    @Insert("INSERT into students(sno, name, password, sex, academy, major, grade,state) VALUES (#{sno}, #{name}," +
            "#{password}, #{sex}, #{academy}, #{major}, #{grade}), #{state}")
    Integer insert(Students students);

    //更新
    @Update("update students set sno = #{sno}, name = #{name}, sex = #{sex}, academy = #{academy}, " +
            "major = #{major}, grade = #{grade}, state = #{state} where sno = #{sno}")
    Integer update(Students students);

    //删除
    @Delete("delete from students where sno = #{sno}")
    Integer deleteBySno(@Param("sno") String sno);


}
