package com.data.jdbc.rest.api.mappers;

import com.data.jdbc.rest.api.dto.EmployeeDTO;
import com.data.jdbc.rest.api.entity.Employee;
import com.data.jdbc.rest.api.mappers.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeEntityMapper extends BaseMapper<EmployeeDTO, Employee> {
    EmployeeEntityMapper INSTANCE = Mappers.getMapper(EmployeeEntityMapper.class);
}
