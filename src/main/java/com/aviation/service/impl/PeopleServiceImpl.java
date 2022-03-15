package com.aviation.service.impl;

import com.aviation.entity.People;
import com.aviation.mapper.PeopleMapper;
import com.aviation.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {

    @Autowired(required = false)
    private PeopleMapper peopleMapper;

    @Override
    public List<People> getPeopleList(int flight_id) {
        return peopleMapper.getPeopleList(flight_id);
    }

    @Override
    public int addPeople(People people) {
        return peopleMapper.addPeople(people);
    }
}
