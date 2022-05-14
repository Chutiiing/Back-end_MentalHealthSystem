package com.chutiiing.backendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chutiiing.backendsystem.entity.Academy;
import com.chutiiing.backendsystem.entity.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentsMapper extends BaseMapper<Students> {

    //查询
    @Select("select * from students")
    List<Students> findAll();

    //按学号查询
    @Select("select * from students where sno = #{sno}")
    Students findBySno(String sno);

    //分页查询
    @Select("select * from students where sno like #{sno} and name like #{name} and academy like #{academy}" +
            "and grade like #{grade} and state like #{state} limit #{pageNum}, #{pageSize}")
    List<Students> selectPage(Integer pageNum, Integer pageSize, String sno, String name,
                              String academy, String grade, String state);

    //查询总条数
    @Select("select count(*) from students where sno like #{sno} and name like #{name} and academy like #{academy}" +
            "and grade like #{grade} and state like #{state}")
    Integer selectTotalNum(String sno, String name,
                           String academy, String grade, String state);

    //查询所有学生记录总数
    @Select("select count(*) from students")
    Integer stuTotalNum();

    //查询所有学院危险的人数
    @Select("select count(*) from students where state = '危险'")
    Integer stuDangerNum();

    //查询各个学院的情况
    @Select("select academy, count(*) total, count(state = \"危险\" or null) danger " +
            "from students group by academy order by danger desc")
    List<Academy> academyResult();


    //插入
    @Insert("INSERT into students(sno, name, password, sex, academy, " +
            "major, grade, state) VALUES (#{sno}, #{name}, #{password}, #{sex}, #{academy}, #{major}, #{grade}, #{state})")
    int insert(Students students);

    //更新
    @Update("update students set sno = #{sno}, name = #{name}, password = #{password}, sex = #{sex}, academy = #{academy}, " +
            "major = #{major}, grade = #{grade}, state = #{state} where sno = #{sno}")
    Integer update(Students students);

    //删除
    @Delete("delete from students where sno = #{sno}")
    Integer deleteBySno(@Param("sno") String sno);

}
