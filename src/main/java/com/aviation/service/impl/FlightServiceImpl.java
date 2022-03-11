package com.aviation.service.impl;

import com.aviation.entity.Flight;
import com.aviation.mapper.FlightMapper;
import com.aviation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("flightService")
public class FlightServiceImpl implements FlightService {
    @Autowired(required = false)
    private FlightMapper flightMapper;

    @Override
    public List<Flight> getAllFlight() {
        return flightMapper.getAllFlight();
    }

    @Override
    public Flight getFlightInfo(int flight_id) {
        return flightMapper.getFlightInfo(flight_id);
    }

    @Override
    public int delFlight(int flight_id) {
        return flightMapper.delFlight(flight_id);
    }

    @Override
    public int updateFlight(Flight flight) {
        return flightMapper.updateFlight(flight);
    }
}
