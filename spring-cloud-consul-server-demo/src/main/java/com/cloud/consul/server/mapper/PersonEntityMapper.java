package com.cloud.consul.server.mapper;

import com.cloud.consul.server.dto.PersonDTO;
import com.cloud.consul.server.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonEntityMapper extends BaseMapper<PersonDTO, Person> {
    PersonEntityMapper INSTANCE = Mappers.getMapper(PersonEntityMapper.class);
}
