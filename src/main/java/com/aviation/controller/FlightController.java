package com.aviation.controller;

import com.aviation.entity.Flight;
import com.aviation.service.FlightService;
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

    @RequestMapping("/getflightlist")
    public String getFlightList(Model model){
        List<Flight> flightList = flightService.getAllFlight();
        model.addAttribute("flightlist",flightList);
        return "aviation/allFlight";
    }
}
