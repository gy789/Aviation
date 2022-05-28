package com.aviation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.aviation.entity.*;
import com.aviation.service.CompanyService;
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
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/")
public class FlightController {

    @Autowired(required = false)
    private FlightService flightService;

    @Autowired(required = false)
    private SeatService seatService;

    @Autowired(required = false)
    private PeopleService peopleService;

    @Autowired(required = false)
    private CompanyService companyService;

    String[] seat_number =
            {"31A","31B","31C","31H","31J","31K",
             "32A","32B","32C","32H","32J","32K",
             "33A","33B","33C","33H","33J","33K",
             "34A","34B","34C","34H","34J","34K",
             "35A","35B","35C","35H","35J","35K",
             "36A","36B","36C","36H","36J","36K",
             "37A","37B","37C","37H","37J","37K",
             "38A","38B","38C","38H","38J","38K",
             "39A","39B","39C","39H","39J","39K",
             "40A","40B","40C","40H","40J","40K",
             "41A","41B","41C","41H","41J","41K",
             "42A","42B","42C","42H","42J","42K",
             "43A","43B","43C","43H","43J","43K",
             "44A","44B","44C","44H","44J","44K",
             "45A","45B","45C","45H","45J","45K",
             "46A","46B","46C","46H","46J","46K",
             "47A","47B","47C","47H","47J","47K",
             "48A","48B","48C","48H","48J","48K",
             "49A","49B","49C","49H","49J","49K",
             "50A","50B","50C","50H","50J","50K",
             "51A","51B","51C","51H","51J","51K"};


    @RequestMapping("/getflightlist")
    public String getFlightList(Model model, HttpServletRequest request){

        int type = Integer.parseInt(request.getParameter("type"));
        //type为2，展示用户当前时间之后的所有航班信息。
        if(type == 2 ){
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String nowdate = dateFormat.format(now);

            List<Flight> flightList = flightService.getAllFlight(type,nowdate,"");
            for (Flight f : flightList){
                Map<String,Object> params = new HashMap<String,Object>();
                params.put("flight_id",f.getFlight_id());
                params.put("nowdate",nowdate);
                int seat_count = seatService.CountSeat(params);
                f.setSeat_count(seat_count);
            }
            model.addAttribute("flightlist",flightList);
            return "aviation/allFlight";
        }
        else if(type == 1){
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("type","1");
            params.put("company_number","");
            params.put("uid",user.getUid());

            Company company = companyService.getCompanyInfo(params);

            List<Flight> flightList = flightService.getAllFlight(type,"",company.getCompany_name());
            model.addAttribute("flightlist",flightList);
            return "aviation/FlightList";
        }
        else if (type == 0){
            List<Flight> flightList = flightService.getAllFlight(type,"","");
            model.addAttribute("flightlist",flightList);
            return "aviation/FlightList";
        }

        return "/aviation/404";
    }

    @RequestMapping("/searchFlight")
    @ResponseBody
    public Msg SearchFlightList(@RequestParam("params")String frontparams) {
        Date now = new Date();
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String nowtime = time.format(now);
        String nowdate = date.format(now);


        Map<String,Object> params = new HashMap<String,Object>();
        params = JSON.parseObject(frontparams,Map.class);
        params.put("nowtime",nowtime);
        params.put("nowdate",nowdate);

        try {
            if (date.parse(params.get("date").toString()).compareTo(date.parse(nowdate)) < 0) {
                return Msg.success(null);
            }
        }catch (ParseException p){
            p.getErrorOffset();
        }
        List<Flight> flightList = flightService.searchFlight(params);
        for (Flight f : flightList) {
            params.put("flight_id",f.getFlight_id());
            int seat_count = seatService.CountSeat(params);
            f.setSeat_count(seat_count);
        }
        JSONArray jsonArray = JSONArray.parseArray(JSONArray.toJSONString(flightList));
        return Msg.success(jsonArray.toString());

    }

    @RequestMapping("/addOneFlight")
    public String AddOneFlight(Model model,Flight flight){
        List<Flight> flightList = new ArrayList<>();
        List<Seat> seats = new ArrayList<>();

        String flight_id = UUID.randomUUID().toString().trim().replace("-","");
        flight.setFlight_id(flight_id);

        flightList.add(flight);
        for (Flight f : flightList){
            for (int i=0;i<f.getSeat_basic_count();i++){
                Seat seat = new Seat();
                seat.setFlight_number(f.getFlight_number());
                seat.setSeat_number(seat_number[i]);
                seat.setFlight_id(f.getFlight_id());
                seats.add(seat);
            }
        }
        int flag_flight = flightService.addFlight(flightList);
        int flag_seat = seatService.AddSeat(seats);

        if (flag_flight > 0 && flag_seat > 0){
            return "redirect:/getflightlist?type=1";
        }
        return "/aviation/addAviationInfo";
    }

    @RequestMapping("/addFlight")
    @ResponseBody
    public Msg AddFlight(@RequestParam("file")MultipartFile file){
        List<Seat> seats = new ArrayList<>();
        try {
            InputStream is = file.getInputStream();
            List<Flight> flightList = Utils.ReadExcelData(is);
            for (Flight f : flightList){
                for (int i=0;i<f.getSeat_basic_count();i++){
                    Seat seat = new Seat();
                    seat.setFlight_number(f.getFlight_number());
                    seat.setSeat_number(seat_number[i]);
                    seat.setFlight_id(f.getFlight_id());
                    seats.add(seat);
                }
            }
            int flag_flight = flightService.addFlight(flightList);
            int flag_seat = seatService.AddSeat(seats);

            if (flag_flight > 0 && flag_seat > 0){
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

        Flight flight = flightService.getFlightInfo(param);
        if (flight == null){
            model.addAttribute("error","系统异常");
            return "/aviation/FlightList";
        }
        model.addAttribute("flight",flight);
        return "/aviation/FlightInfo";
    }

    @RequestMapping("/updateflight")
    public String UpdateFlight(Model model,Flight flight){
        int flag = flightService.updateFlight(flight);
        if(flag > 0){
            return "redirect:getflightlist?type=1";
        }
        model.addAttribute("error","修改失败");
        return "/aviation/FlightInfo";
    }

    @RequestMapping("/delflight")
    @ResponseBody
    public Msg DelFlight(@RequestParam("flight_id")String flight_id){
        int flag = flightService.delFlight(flight_id);
        if (flag > 0){
            return Msg.success("删除成功");
        }
        return Msg.fail("删除失败");
    }
}
