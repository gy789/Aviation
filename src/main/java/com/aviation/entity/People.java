package com.aviation.entity;

public class People {
    private int people_id;
    private String people_name;
    private String people_number;
    private int uid;

    @Override
    public String toString() {
        return "People{" +
                "people_id=" + people_id +
                ", people_name='" + people_name + '\'' +
                ", people_number='" + people_number + '\'' +
                ", uid=" + uid +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    public String getPeople_name() {
        return people_name;
    }

    public void setPeople_name(String people_name) {
        this.people_name = people_name;
    }

    public String getPeople_number() {
        return people_number;
    }

    public void setPeople_number(String people_number) {
        this.people_number = people_number;
    }

}
