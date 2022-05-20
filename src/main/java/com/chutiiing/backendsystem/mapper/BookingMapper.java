package com.chutiiing.backendsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chutiiing.backendsystem.entity.Booking;
import com.chutiiing.backendsystem.entity.StuBooking;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookingMapper extends BaseMapper<Booking> {

    ///////////////教师端//////////////////////////////

    //分页查询
    @Select("select booking.id,booking.time,booking.sno,booking.isbooking,booking.tno,teacher.room from booking,teacher " +
            "where booking.isbooking like #{isbooking} and booking.tno = #{tno} and booking.tno = teacher.tno  limit #{pageNum}, #{pageSize}")
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

    /////////////////学生端/////////////////////////////
    //学生端查询预约信息
    @Select("select booking.id, teacher.username,booking.time,teacher.introduction,teacher.phone,teacher.room from booking,teacher " +
            "where booking.tno = teacher.tno and booking.isbooking = \"未预约\" and booking.time > #{time}")
    List<StuBooking> findBooking(String time);

    //更新预约信息为预约
    @Update("update booking set sno = #{sno}, isBooking = '已预约' where id = #{id}")
    Integer update(String sno,String id);

    //学生端查询预约记录
    @Select("select booking.id, teacher.username,booking.time,teacher.introduction,teacher.phone,teacher.room from booking,teacher " +
            "where booking.tno = teacher.tno and booking.sno = #{sno}")
    List<StuBooking> findStuBooking(String sno);

    //取消预约
    @Update("update booking set sno = null, isBooking = '未预约' where id = #{id}")
    Integer delBooking(String id);
}
