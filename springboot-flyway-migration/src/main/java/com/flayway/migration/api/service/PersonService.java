package com.flayway.migration.api.service;

import com.flayway.migration.api.model.PersonDto;

import java.util.List;

public interface PersonService {
    public PersonDto getPersonById(String id);
    public List<PersonDto> getAllPersons();
    public PersonDto createPerson(PersonDto personDto);
}
