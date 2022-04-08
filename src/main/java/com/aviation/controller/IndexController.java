package com.aviation.controller;

import com.aviation.entity.Users;
import com.aviation.service.MenuService;
import com.aviation.util.CreateMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired(required = false)
    private MenuService menuService;


    @RequestMapping("/index")
    public String GetIndex(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users)session.getAttribute("user");

        try {
            CreateMenu cm = new CreateMenu(user.getRole(),menuService);
            model.addAttribute("menu",cm.printMenu());

            return "/aviation/index";
        }catch (Exception e){
            return "Login";
        }

    }

    /*@RequestMapping("/index_v2")
    public String GetIndexV2(Model model){


        String firstDay = Utils.getFirstDay(true);
        String lastDay = Utils.getLastDay(true);
        int monExpressage_number = expressageService.getMonExpressage(firstDay,lastDay,0);
        int monExpressage_compelete_number = expressageService.getMonExpressage(firstDay,lastDay,1);
        int monExpressage_wait_number = expressageService.getMonExpressage(firstDay,lastDay,2);
        String monExpressage_amount = "0.00";
        try{
            monExpressage_amount = expressageService.getMonExpressageAmount(firstDay,lastDay);
        }catch (Exception e){
            monExpressage_amount= "0.00";
        }

        List<Expressagenews> newslist = newsService.getNewsList();

        model.addAttribute("monExpressage_number",monExpressage_number);
        model.addAttribute("monExpressage_compelete_number",monExpressage_compelete_number);
        model.addAttribute("monExpressage_wait_number",monExpressage_wait_number);
        model.addAttribute("newslist",newslist);
        model.addAttribute("monExpressage_amount",monExpressage_amount);
        return "index_v1";
    }*/
}
