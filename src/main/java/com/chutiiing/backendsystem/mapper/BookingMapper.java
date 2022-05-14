package com.chutiiing.backendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chutiiing.backendsystem.entity.Booking;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookingMapper extends BaseMapper<Booking> {

    //分页查询
    @Select("select booking.id,booking.time,booking.sno,booking.isbooking,booking.tno,teacher.room from booking,teacher " +
            "where booking.isbooking like #{isbooking} and booking.tno = #{tno} and booking.tno = teacher.tno limit #{pageNum}, #{pageSize}")
    List<Booking> selectPage(Integer pageNum, Integer pageSize, String isbooking, String tno);

    //查询总条数
    @Select("select count(*) from booking where isbooking like #{isbooking} and tno = #{tno}")
    Integer selectTotalNum(String isbooking, String tno);

    //删除
    @Delete("delete from booking where id = #{id}")
    Integer deleteById(@Param("id") String id);

    //查询指定老师已经预约人数
    @Select("select count(*) from booking where tno = #{tno} and isbooking = '已预约'")
    Integer countAlready(String tno);

    //查询指定老师未预约人数
    @Select("select count(*) from booking where tno = #{tno} and isbooking = '未预约'")
    Integer countNo(String tno);

    //插入
    @Insert("INSERT into booking(time, tno, isbooking, sno) VALUES (#{time}, #{tno}, #{isbooking}, #{sno})")
    int insert(Booking booking);
}
