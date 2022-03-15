package com.aviation.controller;

import com.aviation.entity.People;
import com.aviation.entity.Users;
import com.aviation.mapper.PeopleMapper;
import com.aviation.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class PeopleController {

    @Autowired(required = false)
    private PeopleMapper peopleMapper;

    @RequestMapping("/addPeople")
    @ResponseBody
    public Msg AddPeople(HttpServletRequest request, People people){
        HttpSession session = request.getSession();
        Users users = (Users)session.getAttribute("user");
        people.setUid(users.getUid());
        int flag = peopleMapper.addPeople(people);
        if (flag > 0){
            return Msg.success("成功");
        }
        return Msg.fail("失败");
    }
}
