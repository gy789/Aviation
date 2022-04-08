package com.aviation.controller;

import com.aviation.entity.Flight;
import com.aviation.entity.People;
import com.aviation.service.FlightService;
import com.aviation.service.PeopleService;
import com.aviation.service.SeatService;
import com.aviation.util.Msg;
import com.aviation.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public String getFlightList(Model model, HttpServletRequest request){

        int type = Integer.parseInt(request.getParameter("type"));
        //type为1，展示用户当前时间之后的所有航班信息。
        if(type == 1){
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String nowDate = dateFormat.format(now);

            List<Flight> flightList = flightService.getAllFlight(type,nowDate);
            for (Flight f : flightList){
                int seat_count = seatService.CountSeat(f.getFlight_id());
                f.setSeat_count(seat_count);
            }
            model.addAttribute("flightlist",flightList);
            return "aviation/allFlight";
        }


        return "";


    }

    @RequestMapping("/addFlight")
    @ResponseBody
    public Msg AddFlight(@RequestParam("file")MultipartFile file){

        try {
            InputStream is = file.getInputStream();
            List<Flight> flightList = Utils.ReadExcelData(is);
            int flag = flightService.addFlight(flightList);
            if (flag > 0 ){
                return Msg.success("成功");
            }
            return Msg.fail("失败");
        }catch (Exception e){
            e.printStackTrace();
            return Msg.fail("失败");
        }
    }

    @RequestMapping("/skipflightinfo")
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
