package com.chutiiing.backendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chutiiing.backendsystem.entity.Test;
import com.chutiiing.backendsystem.entity.TestName;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestMapper extends BaseMapper<Test> {

    /////////////////////////////////教师端/////////////////////////////////////////////

    //分页查询
    @Select("select * from test_name where title like #{title} limit #{pageNum}, #{pageSize}")
    List<Test> selectPage(Integer pageNum, Integer pageSize, String title);

    //查询总条数
    @Select("select count(*) from test_name where title like #{title}")
    Integer selectTotalNum(String title);

    //删除
    @Delete("delete from test_name where tableid = #{tableid}")
    Integer deleteById(@Param("tableid") String tableid);

    //插入
    @Insert("INSERT into test_name(tableid, title, introduction, admin ) VALUES (#{tableid},#{title}, #{introduction},#{admin})")
    int insert(Test test);

    //查询已有的量表title
    @Select("select title from test_name")
    List<TestName> findName();

    //////////////////////////////////学生端/////////////////////////////////

    //查询
    @Select("select * from test_name")
    List<Test> findAll();

}
