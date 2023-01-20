package com.flayway.migration.api.controller;

import com.flayway.migration.api.model.PersonDto;
import com.flayway.migration.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable String id){
        return this.personService.getPersonById(id);
    }

    @GetMapping("")
    public List<PersonDto> getAllPersons(){
        return this.personService.getAllPersons();
    }

    @PostMapping("")
    public PersonDto createPerson(@RequestBody PersonDto personDto){
        return this.personService.createPerson(personDto);
    }
}
