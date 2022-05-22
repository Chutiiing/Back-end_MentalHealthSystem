package com.chutiiing.backendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chutiiing.backendsystem.entity.TestHistory;
import com.chutiiing.backendsystem.entity.TestRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestHistoryMapper extends BaseMapper<TestHistory> {

    //查询某张表填写总人数
    @Select("select count(distinct(test_history.sno)) num from test_history,test_name " +
            "where test_name.tableid = test_history.tableid and  test_name.title = #{title} ")
    Integer countNum(String title);

    //插入
    @Insert("INSERT into test_history(sno, tableid, result) VALUES (#{sno}, #{tableid}, #{result})")
    int insert(TestHistory testHistory);

    //查询测评记录
    @Select("select test_name.title, test_history.result, test_history.date from test_name,test_history " +
            "where test_history.tableid = test_name.tableid and test_history.sno = #{sno}")
    List<TestRecord> findList(String sno);
}
