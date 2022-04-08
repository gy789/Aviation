package com.aviation.entity;

public class Flight {
    private int flight_id;//航班id
    private String flight_start;//航班起飞地
    private String flight_end;//航班终点地
    private String flight_start_time;//航班起飞时间
    private String flight_arrive_time;//航班达到时间
    private String company_name;//航班公司名
    private String flight_price;//价格
    private String flight_time;//航班飞行时间
    private String create_time;//创建时间
    private String update_time;//更新时间
    private int seat_count;//座位数
    private String flight_number;//航班号

    @Override
    public String toString() {
        return "Flight{" +
                "flight_id=" + flight_id +
                ", flight_start='" + flight_start + '\'' +
                ", flight_end='" + flight_end + '\'' +
                ", flight_start_time='" + flight_start_time + '\'' +
                ", flight_arrive_time='" + flight_arrive_time + '\'' +
                ", company_name='" + company_name + '\'' +
                ", flight_price='" + flight_price + '\'' +
                ", flight_time='" + flight_time + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", seat_count=" + seat_count +
                ", flight_number='" + flight_number + '\'' +
                '}';
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getFlight_time() {
        return flight_time;
    }

    public void setFlight_time(String flight_time) {
        this.flight_time = flight_time;
    }

    public String getFlight_price() {
        return flight_price;
    }

    public void setFlight_price(String flight_price) {
        this.flight_price = flight_price;
    }

    public int getSeat_count() {
        return seat_count;
    }

    public void setSeat_count(int seat_count) {
        this.seat_count = seat_count;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getFlight_start() {
        return flight_start;
    }

    public void setFlight_start(String flight_start) {
        this.flight_start = flight_start;
    }

    public String getFlight_end() {
        return flight_end;
    }

    public void setFlight_end(String flight_end) {
        this.flight_end = flight_end;
    }

    public String getFlight_start_time() {
        return flight_start_time;
    }

    public void setFlight_start_time(String flight_time) {
        this.flight_start_time = flight_time;
    }

    public String getFlight_arrive_time() {
        return flight_arrive_time;
    }

    public void setFlight_arrive_time(String flight_arrive_time) {
        this.flight_arrive_time = flight_arrive_time;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
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
