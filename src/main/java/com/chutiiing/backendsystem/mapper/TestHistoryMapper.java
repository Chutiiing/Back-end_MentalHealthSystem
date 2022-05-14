package com.chutiiing.backendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chutiiing.backendsystem.entity.TestHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestHistoryMapper extends BaseMapper<TestHistory> {

    //查询某张表填写总人数
    @Select("select count(distinct(sno)) num from test_history where title = #{title} ")
    Integer countNum(String title);
}
