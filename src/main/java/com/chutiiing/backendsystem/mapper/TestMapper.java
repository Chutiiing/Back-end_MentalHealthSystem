package com.chutiiing.backendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chutiiing.backendsystem.entity.Test;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper extends BaseMapper<Test> {
    //查询
    @Select("select * from test_name")
    List<Test> findAll();

    //分页查询
    @Select("select * from test_name where title like #{title} limit #{pageNum}, #{pageSize}")
    List<Test> selectPage(Integer pageNum, Integer pageSize, String title);

    //查询总条数
    @Select("select count(*) from test_name where title like #{title}")
    Integer selectTotalNum(String title);

    //删除
    @Delete("delete from test_name where tableid = #{tableid}")
    Integer deleteById(@Param("tableid") String tableid);
}
