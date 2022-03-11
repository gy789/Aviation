package com.aviation.entity;

public class Flight {
    private int flight_id;
    private String flight_start;
    private String flight_end;
    private String flight_time;
    private String flight_arrive_time;
    private Company company;
    private String create_time;
    private String update_time;

    @Override
    public String toString() {
        return "Flight{" +
                "flight_id=" + flight_id +
                ", flight_start='" + flight_start + '\'' +
                ", flight_end='" + flight_end + '\'' +
                ", flight_time='" + flight_time + '\'' +
                ", flight_arrive_time='" + flight_arrive_time + '\'' +
                ", company=" + company +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
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

    public String getFlight_time() {
        return flight_time;
    }

    public void setFlight_time(String flight_time) {
        this.flight_time = flight_time;
    }

    public String getFlight_arrive_time() {
        return flight_arrive_time;
    }

    public void setFlight_arrive_time(String flight_arrive_time) {
        this.flight_arrive_time = flight_arrive_time;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
