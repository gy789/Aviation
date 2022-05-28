package com.aviation.mapper;

import com.aviation.entity.Seat;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SeatMapper {
    int CountSeat(@Param("params") Map<String,Object> params);
    int AddSeat(List<Seat> seats);
    List<Seat> getSeatList(@Param("params") Map<String,Object> params);
}
