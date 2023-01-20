package com.data.jdbc.rest.api.mappers;

import com.data.jdbc.rest.api.dto.CustomerDTO;
import com.data.jdbc.rest.api.entity.Customer;
import com.data.jdbc.rest.api.mappers.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerEntityMapper extends BaseMapper<CustomerDTO, Customer> {
    CustomerEntityMapper INSTANCE = Mappers.getMapper(CustomerEntityMapper.class);
}
