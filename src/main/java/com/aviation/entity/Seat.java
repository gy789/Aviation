package com.aviation.entity;

public class Seat {
    private int seat_id;
    private String flight_number;
    private String seat_number;
    private String flight_id;

    @Override
    public String toString() {
        return "Seat{" +
                "seat_id=" + seat_id +
                ", flight_number='" + flight_number + '\'' +
                ", seat_number='" + seat_number + '\'' +
                ", flight_id=" + flight_id +
                '}';
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }


    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }
}
