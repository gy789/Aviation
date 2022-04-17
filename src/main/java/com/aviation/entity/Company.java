package com.aviation.entity;

public class Company {
    private int company_id;
    private String company_number;
    private String company_name;
    private int uid;

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + company_id +
                ", company_number=" + company_number +
                ", company_name='" + company_name + '\'' +
                ", uid=" + uid +
                '}';
    }

    public String getCompany_number() {
        return company_number;
    }

    public void setCompany_number(String company_number) {
        this.company_number = company_number;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
