package com.mongo.rest.api.mapper;

import com.mongo.rest.api.dto.ComponentDTO;
import com.mongo.rest.api.entity.Component;
import com.mongo.rest.api.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComponentEntityMapper extends BaseMapper<ComponentDTO, Component> {
    ComponentEntityMapper INSTANCE = Mappers.getMapper(ComponentEntityMapper.class);
}
