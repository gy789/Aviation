package com.aviation.service;

import com.aviation.entity.People;

import java.util.List;

public interface PeopleService {
    List<People> getPeopleList(int flight_id);
    int addPeople(People people);

}
