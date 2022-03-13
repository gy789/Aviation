package com.aviation.service.impl;

import com.aviation.mapper.SeatMapper;
import com.aviation.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("seatService")
public class SeatServiceImpl implements SeatService {
    @Autowired(required = false)
    private SeatMapper seatMapper;

    @Override
    public int CountSeat(int flight_id) {
        return seatMapper.CountSeat(flight_id);
    }
}
