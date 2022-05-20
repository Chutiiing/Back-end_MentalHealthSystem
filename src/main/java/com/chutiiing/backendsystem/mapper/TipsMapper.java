package com.chutiiing.backendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chutiiing.backendsystem.entity.Collect;
import com.chutiiing.backendsystem.entity.Tips;
import com.chutiiing.backendsystem.entity.TipsStarBySno;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TipsMapper extends BaseMapper<Tips> {
    //查询
    @Select("select id, content from tips")
    List<Tips> findAll();

    //查询贴士有无被收藏
    @Select("select count(*) from collect where tipsId = #{tipsId} and sno = #{sno}")
    Integer isStar(String tipsId,String sno);

    //插入
    @Insert("INSERT into collect(sno, tipsId) VALUES (#{sno}, #{tipsId})")
    Integer insert(Collect collect);

    //删除
    @Delete("delete from collect where sno = #{sno} and tipsId = #{tipsId}")
    Integer delStar(Collect collect);

    //查询贴士收藏
    @Select("select tips.id tipsId, tips.content, tips.time from tips,collect where collect.sno = #{sno} and collect.tipsId = tips.id")
    List<TipsStarBySno> stuStarList(String sno);
}
