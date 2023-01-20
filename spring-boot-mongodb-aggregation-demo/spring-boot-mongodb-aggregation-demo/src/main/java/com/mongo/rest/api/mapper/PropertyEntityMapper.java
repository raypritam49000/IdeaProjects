package com.mongo.rest.api.mapper;

import com.mongo.rest.api.dto.PropertyDTO;
import com.mongo.rest.api.entity.Property;
import com.mongo.rest.api.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PropertyEntityMapper extends BaseMapper<PropertyDTO, Property> {
    PropertyEntityMapper INSTANCE = Mappers.getMapper(PropertyEntityMapper.class);
}
