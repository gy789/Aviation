package com.aviation.mapper;

import com.aviation.entity.Flight;

import java.util.List;

public interface FlightMapper {
    List<Flight> getAllFlight();
    Flight getFlightInfo(int flight_id);
    int delFlight(int flight_id);
    int updateFlight(Flight flight);
}
