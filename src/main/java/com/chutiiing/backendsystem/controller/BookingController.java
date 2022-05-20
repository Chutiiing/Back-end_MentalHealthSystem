package com.chutiiing.backendsystem.controller;

import cn.hutool.core.date.DateUtil;
import com.chutiiing.backendsystem.entity.Booking;
import com.chutiiing.backendsystem.entity.StuBooking;
import com.chutiiing.backendsystem.mapper.BookingMapper;
import com.chutiiing.backendsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private BookingService bookingService;

    /////////////////////////////////教师端接口/////////////////////////////////////////

    //分页查询
    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam String isbooking,
                                       @RequestParam String tno) {
        pageNum = (pageNum - 1) * pageSize;
        isbooking  = "%" + isbooking + "%";    //标题模糊查询
        List<Booking> data = bookingMapper.selectPage(pageNum,pageSize,isbooking,tno);
        Integer total = bookingMapper.selectTotalNum(isbooking,tno);
        Map<String,Object> res = new HashMap<>();
        res.put("total",total);
        res.put("data",data);
        return res;
    }

    //删除预约信息
    @DeleteMapping("/del/{id}")
    public Integer delete(@PathVariable String id){
        return bookingMapper.deleteById(id);
    }

    //查询人数
    @GetMapping("/count/{tno}")
    public Map<String,Object> finishNumTotal(@PathVariable String tno) {
        Map<String,Object> res = new HashMap<>();
        Integer already = bookingMapper.countAlready(tno);     //查询总人数
        Integer no = bookingMapper.countNo(tno);    //查询已填写的人数
        res.put("already",already);
        res.put("no",no);
        return res;
    }

    //插入数据
    //外部传入的student对象作为参数
    //"RequestBody"可以把前端传来的jason数据转换成java对象
    @PostMapping("/insert")
    public Integer insert(@RequestBody Booking booking) {
        return bookingMapper.insert(booking);
    }

    /////////////////////////////////学生端接口/////////////////////////////////////////

    //查询预约信息
    @GetMapping("/findBooking")
    public List<StuBooking> findBooking(){
        //显示的可预约信息应该大于当前时间
        String time = DateUtil.now();
        return bookingMapper.findBooking(time);
    }

    //更新预约信息
    @PostMapping("/updateBooking/{sno}/{id}")
    public Boolean update(@PathVariable String sno, @PathVariable String id){
        return bookingMapper.update(sno,id) == 1;
    }

    //查询学生已经预约的信息
    @GetMapping("/findStuBooking/{sno}")
    public List<StuBooking> findBooking(@PathVariable String sno){
        return bookingMapper.findStuBooking(sno);
    }

    //取消预约
    @PostMapping("/delBooking/{id}")
    public Boolean delBooking(@PathVariable String id){
        return bookingMapper.delBooking(id) == 1;
    }
}
