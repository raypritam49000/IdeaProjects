package com.rest.api.mapper;


import com.rest.api.dto.PersonDTO;
import com.rest.api.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonEntityMapper extends BaseMapper<PersonDTO, Person> {
    PersonEntityMapper INSTANCE = Mappers.getMapper(PersonEntityMapper.class);
}
