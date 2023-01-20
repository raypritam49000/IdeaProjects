package com.data.jdbc.rest.api.mappers;

import com.data.jdbc.rest.api.dto.AddressDTO;
import com.data.jdbc.rest.api.entity.Address;
import com.data.jdbc.rest.api.mappers.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressEntityMapper extends BaseMapper<AddressDTO, Address> {
    AddressEntityMapper INSTANCE = Mappers.getMapper(AddressEntityMapper.class);
}