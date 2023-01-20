package com.rest.api.service.impl;

import com.rest.api.dto.PersonDTO;
import com.rest.api.mapper.PersonEntityMapper;
import com.rest.api.repository.PersonRepository;
import com.rest.api.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;


    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        return PersonEntityMapper.INSTANCE.toDto(personRepository.save(PersonEntityMapper.INSTANCE.toEntity(personDTO)));
    }

    @Override
    public PersonDTO getPerson(String id) {
        return PersonEntityMapper.INSTANCE.toDto(personRepository.findById(id).get());
    }

    @Override
    public List<PersonDTO> getPersons() {
        return PersonEntityMapper.INSTANCE.toDtoList(personRepository.findAll());
    }

    @Override
    public Map<String,Object> deletePerson(String id) {
        personRepository.delete(personRepository.findById(id).get());
        return Map.of("status",200,"isDeleted",true);
    }

    @Override
    public PersonDTO updatePerson(String id, PersonDTO personDTO) {
        personDTO.setId(id);
        return PersonEntityMapper.INSTANCE.toDto(personRepository.save(PersonEntityMapper.INSTANCE.toEntity(personDTO)));
    }
}
