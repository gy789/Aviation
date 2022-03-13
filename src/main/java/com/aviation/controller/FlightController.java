package com.aviation.controller;

import com.aviation.entity.Flight;
import com.aviation.service.FlightService;
import com.aviation.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class FlightController {

    @Autowired(required = false)
    private FlightService flightService;

    @Autowired(required = false)
    private SeatService seatService;


    @RequestMapping("/getflightlist")
    public String getFlightList(Model model){
        List<Flight> flightList = flightService.getAllFlight();
        for (Flight f : flightList){
            int seat_count = seatService.CountSeat(f.getFlight_id());
            f.setSeat_count(seat_count);
        }
        model.addAttribute("flightlist",flightList);
        return "aviation/allFlight";
    }
}
