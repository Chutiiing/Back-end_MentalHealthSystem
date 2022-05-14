package com.chutiiing.backendsystem.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chutiiing.backendsystem.entity.Booking;
import com.chutiiing.backendsystem.mapper.BookingMapper;
import org.springframework.stereotype.Service;

@Service
public class BookingService extends ServiceImpl<BookingMapper, Booking> {
}
