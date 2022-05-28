package com.aviation.service.impl;

import com.aviation.entity.Seat;
import com.aviation.mapper.SeatMapper;
import com.aviation.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("seatService")
public class SeatServiceImpl implements SeatService {
    @Autowired(required = false)
    private SeatMapper seatMapper;

    @Override
    public int CountSeat( Map<String,Object> params) {
        return seatMapper.CountSeat(params);
    }

    @Override
    public int AddSeat(List<Seat> seats) {
        return seatMapper.AddSeat(seats);
    }

    @Override
    public List<Seat> getSeatList(Map<String, Object> params) {
        return seatMapper.getSeatList(params);
    }
}
