package com.aviation.controller;

import com.aviation.entity.People;
import com.aviation.entity.Users;
import com.aviation.mapper.PeopleMapper;
import com.aviation.service.PeopleService;
import com.aviation.util.Msg;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class PeopleController {

    @Autowired(required = false)
    private PeopleService peopleService;

    @RequestMapping("/addPeople")
    @ResponseBody
    public Msg AddPeople(HttpServletRequest request, People people){
        HttpSession session = request.getSession();
        Users users = (Users)session.getAttribute("user");
        people.setUid(users.getUid());
        int flag = peopleService.addPeople(people);
        if (flag > 0){
            return Msg.success("成功");
        }
        return Msg.fail("失败");
    }

    @RequestMapping("/delpeople")
    @ResponseBody
    public Msg DelPeople(@RequestParam("people_id")String param){
        int people_id = Integer.parseInt(param);
        int flag = peopleService.delPeople(people_id);
        if (flag > 0){
            return Msg.success("成功");
        }
        return Msg.fail("失败");
    }
}
