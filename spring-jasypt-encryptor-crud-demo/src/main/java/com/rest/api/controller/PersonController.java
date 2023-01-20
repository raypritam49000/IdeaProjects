package com.rest.api.controller;
import com.rest.api.dto.PersonDTO;
import com.rest.api.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable String id){
        return personService.getPerson(id);
    }

    @PutMapping("/{id}")
    public PersonDTO updatePerson(@PathVariable String id,@RequestBody PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> getPersons(){
        return personService.getPersons();
    }

    @DeleteMapping("/{id}")
    public Map<String,Object> deletePerson(String id){
        return personService.deletePerson(id);
    }
}
