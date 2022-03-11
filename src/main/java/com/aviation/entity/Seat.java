package com.aviation.entity;

public class Seat {
    private int seat_id;
    private int flight_id;
    private String seat_number;

    @Override
    public String toString() {
        return "Seat{" +
                "seat_id=" + seat_id +
                ", flight_id=" + flight_id +
                ", seat_number='" + seat_number + '\'' +
                '}';
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }
}
