package com.aviation.controller;

import com.aviation.entity.AviationNews;
import com.aviation.service.NewsService;
import com.aviation.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class NewsController {

    @Autowired(required = false)
    private NewsService newsService;

    @RequestMapping("/newsList")
    public String getnewsList(Model model){
        List<AviationNews> newslist = newsService.getNewsList();
        model.addAttribute("newslist",newslist);
        return "/aviation/AllNews";
    }
    @RequestMapping("/addnews")
    public String addNews(AviationNews news, Model model, HttpServletRequest request){
        int flag = newsService.addNews(news);
        if (flag > 0){
            return "redirect:/newsList";
        }
        return "/aviation/addNews";
    }

    @RequestMapping("/delnews")
    @ResponseBody
    public Msg deleteNews(@RequestParam("aviation_news_id")String aviation_news_id){
        int flag = newsService.deleteNews(Integer.parseInt(aviation_news_id));
        if (flag > 0){
            return Msg.success("成功");
        }
        return Msg.fail("失败");
    }

    @RequestMapping("/updateNews")
    public String updateNews(AviationNews news, Model model, HttpServletRequest request){
        int flag = newsService.updateNews(news);
        if (flag > 0){
            return "redirect:/newsList";
        }
        return "/aviation/newsdetails";
    }

    @RequestMapping("/skipnews")
    public String getNewsDetails(Model model,@RequestParam("aviation_news_id")String aviation_news_id){
        AviationNews aviationNews = newsService.getNews(Integer.parseInt(aviation_news_id));
        model.addAttribute("aviationNews",aviationNews);
        return "/aviation/newsDetails";
    }
    @RequestMapping("/seanews")
    public String Seanews(Model model,@RequestParam("aviation_news_id")String aviation_news_id){
        AviationNews aviationNews = newsService.getNews(Integer.parseInt(aviation_news_id));
        model.addAttribute("news",aviationNews);
        return "/aviation/article";
    }

}
