package com.aviation.entity;

public class Orders {
    private int order_id;
    private String flight_start;
    private String flight_end;
    private String flight_start_time;
    private String flight_arrive_time;
    private String company_name;
    private String order_price;
    private String flight_time;
    private String create_time;
    private String update_time;
    private int order_status;
    private int uid;

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", flight_start='" + flight_start + '\'' +
                ", flight_end='" + flight_end + '\'' +
                ", flight_start_time='" + flight_start_time + '\'' +
                ", flight_arrive_time='" + flight_arrive_time + '\'' +
                ", company_name='" + company_name + '\'' +
                ", order_price='" + order_price + '\'' +
                ", flight_time='" + flight_time + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", order_status=" + order_status +
                ", uid=" + uid +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public void setFlight_start_time(String flight_start_time) {
        this.flight_start_time = flight_start_time;
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

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getFlight_time() {
        return flight_time;
    }

    public void setFlight_time(String flight_time) {
        this.flight_time = flight_time;
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

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }
}
