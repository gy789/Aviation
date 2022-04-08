package com.aviation.controller;

import com.aviation.entity.Users;
import com.aviation.service.UserService;
import com.aviation.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired(required = false)
    private UserService userService;


    @RequestMapping("/login")
    public String Login(Users u, Model model, HttpServletRequest request){
        Users user = userService.login(u.getUsername(),u.getPassword());
        if(user == null){
            model.addAttribute("errorMsg","用户名或密码错误");
            return "/aviation/Login";
        }else {
            HttpSession session = request.getSession();

            session.setAttribute("user", user);

            return "redirect:/index";
        }
    }

    @RequestMapping("/register")
    public String register(Users user, Model model, HttpServletRequest request) throws Exception{
        user.setRole("2");
        if (user.getPassword().equals("")){
            model.addAttribute("errorMsg","密码为空，请输入密码");
            return "/aviation/Register";
        }
        try {
            userService.register(user);
            return "/aviation/Login";
        }catch (Exception e){
            model.addAttribute("errorMsg","注册失败(用户名重复)");
            return "/aviation/Register";
        }
    }

    @RequestMapping("/userlist")
    public String getUserList(Model model){
        List<Users> usersList = userService.getAllUsers();
        model.addAttribute("userlist",usersList);
        return "/aviation/allusers";
    }

    @RequestMapping("/deleteuser")
    @ResponseBody
    public Msg deleteuser(@RequestParam("uid")String uid){
        int flag = userService.deleteUsers(Integer.parseInt(uid));
        if(flag > 0){
            return Msg.success("删除成功");
        }else {
            return Msg.fail("删除失败");
        }
    }

    @RequestMapping("/getusers")
    public String getusers(@RequestParam("uid")String uid,Model model){
        Users users = userService.getUsers(Integer.parseInt(uid));
        if(users == null){
            model.addAttribute("error","系统异常");
            return "/aviation/allusers";
        }
        model.addAttribute("users",users);
        return "/aviation/userdetails";

    }

    @RequestMapping("/myinfo")
    public String MyInfo(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Users users = (Users)session.getAttribute("user");
        Users u = userService.getUsers(users.getUid());
        model.addAttribute("users",u);
        return "/aviation/userdetails";
    }

    @RequestMapping("/adduser")
    public String adduser(Users u, Model model, HttpServletRequest request){
        int flag = userService.addUser(u);
        if(flag == 0){
            model.addAttribute("error","添加失败");
            return "/aaviation/addusr";
        }else {
            return "redirect:userlist";
        }
    }

    @RequestMapping("/updateuser")
    public String updateuser(Users u, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Users user = (Users)session.getAttribute("user");
        try {
            if (u.getRole().equals("") && u.getRole() == null){

                u.setRole(user.getRole());
            }

        }catch (Exception e){
            u.setRole(user.getRole());
        }
        int flag = userService.updateUser(u);
        if (user.getRole().equals("0")) {
            if (flag == 0) {
                model.addAttribute("error", "修改失败");
                return "/aviation/userdetails";
            } else {
                return "redirect:/userlist";
            }
        }else {
            if (flag == 0) {
                model.addAttribute("error", "修改失败");
                return "/aviation/userdetails";
            } else {
                return "redirect:myinfo";
            }
        }

    }

}
