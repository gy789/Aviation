package com.aviation.service;

import com.aviation.entity.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getAllFlight();
    Flight getFlightInfo(int flight_id);
    int delFlight(int flight_id);
    int updateFlight(Flight flight);
}
