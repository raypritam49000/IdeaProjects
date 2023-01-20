package com.cloud.consul.server.service;

import com.cloud.consul.server.dto.PersonDTO;

import java.util.List;
import java.util.Map;

public interface PersonService {
    PersonDTO createPerson(PersonDTO personDTO);
    PersonDTO getPerson(String id);
    List<PersonDTO> getPersons();
    public Map<String,Object> deletePerson(String id);
    PersonDTO updatePerson(String id,PersonDTO personDTO);
}
