package com.aviation.service.impl;


import com.aviation.entity.AviationNews;
import com.aviation.mapper.NewsMapper;
import com.aviation.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Autowired(required = false)
    private NewsMapper newsMapper;

    @Override
    public List<AviationNews> getNewsList() {
        return newsMapper.getNewsList();
    }

    @Override
    public int addNews(AviationNews aviationNews) {
        return newsMapper.addNews(aviationNews);
    }

    @Override
    public int updateNews(AviationNews aviationNews) {
        return newsMapper.updateNews(aviationNews);
    }

    @Override
    public int deleteNews(int aviation_news_id) {
        return newsMapper.deleteNews(aviation_news_id);
    }

    @Override
    public AviationNews getNews(int aviation_news_id) {
        return newsMapper.getNews(aviation_news_id);
    }
}
