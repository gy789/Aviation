package com.aviation.controller;

import com.alibaba.fastjson.JSON;
import com.aviation.entity.Company;
import com.aviation.service.CompanyService;
import com.aviation.service.UserService;
import com.aviation.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class CompanyController {

    @Autowired(required = false)
    private CompanyService companyService;


    @RequestMapping("/companylist")
    public String GetCompanyList(Model model){
        List<Company> companyList = companyService.getAllCompany();
        model.addAttribute("companyList",companyList);
        return "aviation/AllCompany";
    }

    @RequestMapping("/deleteCompany")
    @ResponseBody
    public Msg DeleteCompany(@RequestParam("company_number")String company_number){

        int flag = companyService.delCompany(company_number);
        if (flag > 0 ){
            return Msg.success("删除成功");
        }
        return Msg.fail("删除成功");
    }

    @RequestMapping("/binduser")
    @ResponseBody
    public Msg BindUser(@RequestParam("params")String frontparams){
        Map<String,Object> params = new HashMap<String,Object>();
        params = JSON.parseObject(frontparams,Map.class);
        int flag = companyService.addCompany(params);
        if(flag > 0){
            return Msg.success("绑定成功");
        }else {
            return Msg.fail("绑定成功");
        }

    }

    @RequestMapping("/addCompany")
    public String AddCompany(Company company, Model model){

        String company_number = UUID.randomUUID().toString().trim().replace("-","");

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("company_number",company_number);
        params.put("company_name",company.getCompany_name());
        params.put("uid",null);
        int flag = companyService.addCompany(params);
        if (flag > 0){
            return "redirect:/companylist";
        }
        model.addAttribute("error","添加失败");
        return "aviation/addCompany";
    }
}
