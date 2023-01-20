package com.flayway.migration.api.service.impl;

import com.flayway.migration.api.entity.Person;
import com.flayway.migration.api.model.PersonDto;
import com.flayway.migration.api.repository.PersonRepository;
import com.flayway.migration.api.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PersonDto getPersonById(String id) {
        Person person = personRepository.findById(id).get();
       return this.modelMapper.map(person,PersonDto.class);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        List<PersonDto> personDtoList = persons.stream()
                .map(person -> this.modelMapper.map(person,PersonDto.class)).collect(Collectors.toList());
        return personDtoList;
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = this.modelMapper.map(personDto,Person.class);
        Person createPerson = personRepository.save(person);
        return this.modelMapper.map(createPerson,PersonDto.class);
    }
}
