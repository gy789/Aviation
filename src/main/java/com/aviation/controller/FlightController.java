package com.aviation.controller;

import com.aviation.entity.Flight;
import com.aviation.entity.People;
import com.aviation.service.FlightService;
import com.aviation.service.PeopleService;
import com.aviation.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class FlightController {

    @Autowired(required = false)
    private FlightService flightService;

    @Autowired(required = false)
    private SeatService seatService;

    @Autowired(required = false)
    private PeopleService peopleService;


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
    @RequestMapping("/getflightinfo")
    public String getFlightInfo(Model model, @RequestParam("flight_id")String param){
        int flight_id = Integer.parseInt(param);
        Flight flight = flightService.getFlightInfo(flight_id);
        List<People> peopleList = peopleService.getPeopleList(flight_id);
        if (flight == null){
            model.addAttribute("error","系统异常");
            return "/aviation/allFlight";
        }
        model.addAttribute("flight",flight);
        model.addAttribute("peoplelist",peopleList);
        return "/aviation/FlightInfo";
    }
}
