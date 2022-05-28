package com.aviation.service.impl;

import com.aviation.entity.Flight;
import com.aviation.mapper.FlightMapper;
import com.aviation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("flightService")
public class FlightServiceImpl implements FlightService {
    @Autowired(required = false)
    private FlightMapper flightMapper;

    @Override
    public List<Flight> getAllFlight(int type,String nowDate,String company_name) {
        return flightMapper.getAllFlight(type,nowDate,company_name);
    }

    @Override
    public List<Flight> searchFlight(Map<String, Object> params) {
        return flightMapper.searchFlight(params);
    }

    @Override
    public Flight getFlightInfo(String flight_id) {
        return flightMapper.getFlightInfo(flight_id);
    }

    @Override
    public int delFlight(String flight_id) {
        return flightMapper.delFlight(flight_id);
    }

    @Override
    public int updateFlight(Flight flight) {
        return flightMapper.updateFlight(flight);
    }

    @Override
    public int addFlight(List<Flight> flightList) {
        return flightMapper.addFlight(flightList);
    }
}
