package com.aviation.mapper;


import com.aviation.entity.AviationNews;

import java.util.List;

public interface NewsMapper {
    List<AviationNews> getNewsList();//得到所有新闻
    int addNews(AviationNews aviationNews);//添加新闻
    int updateNews(AviationNews aviationNews);//修改新闻
    int deleteNews(int aviation_news_id);//删除新闻
    AviationNews getNews(int aviation_news_id);//得到详情
}
