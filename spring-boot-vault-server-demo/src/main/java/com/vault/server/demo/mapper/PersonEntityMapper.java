package com.vault.server.demo.mapper;

import com.vault.server.demo.dto.PersonDTO;
import com.vault.server.demo.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonEntityMapper extends BaseMapper<PersonDTO, Person> {
    PersonEntityMapper INSTANCE = Mappers.getMapper(PersonEntityMapper.class);
}
