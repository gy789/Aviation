package com.aviation.mapper;

import com.aviation.entity.People;

import java.util.List;

public interface PeopleMapper {
    List<People> getPeopleList(int flight_id);
    int addPeople(People people);
    int delPeople(int people_id);
    People getPeopleInfo(int people_id);
    int updatePeoplieInfo(People people);
}
