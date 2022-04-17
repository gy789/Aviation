package com.aviation.mapper;

import com.aviation.entity.Flight;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FlightMapper {
    List<Flight> getAllFlight(@Param("type")int type,@Param("nowDate")String nowDate,@Param("company_name")String company_name);
    List<Flight> searchFlight(@Param("params") Map<String,Object> params);
    Flight getFlightInfo(int flight_id);
    int delFlight(int flight_id);
    int updateFlight(Flight flight);
    int addFlight(List<Flight> flights);
}
