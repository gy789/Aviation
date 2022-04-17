package com.aviation.entity;

public class AviationNews {
    private int aviation_news_id;
    private String aviation_news_title;
    private String aviation_news_info;
    private String create_time;
    private String update_time;

    @Override
    public String toString() {
        return "AviationNews{" +
                "aviation_news_id=" + aviation_news_id +
                ", aviation_news_title='" + aviation_news_title + '\'' +
                ", aviation_news_info='" + aviation_news_info + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }

    public int getAviation_news_id() {
        return aviation_news_id;
    }

    public void setAviation_news_id(int aviation_news_id) {
        this.aviation_news_id = aviation_news_id;
    }

    public String getAviation_news_title() {
        return aviation_news_title;
    }

    public void setAviation_news_title(String aviation_news_title) {
        this.aviation_news_title = aviation_news_title;
    }

    public String getAviation_news_info() {
        return aviation_news_info;
    }

    public void setAviation_news_info(String aviation_news_info) {
        this.aviation_news_info = aviation_news_info;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
