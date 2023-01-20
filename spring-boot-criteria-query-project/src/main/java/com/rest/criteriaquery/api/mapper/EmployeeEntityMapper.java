package com.rest.criteriaquery.api.mapper;

import com.rest.criteriaquery.api.dto.EmployeeDTO;
import com.rest.criteriaquery.api.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeEntityMapper extends BaseMapper<EmployeeDTO, Employee> {
    EmployeeEntityMapper INSTANCE = Mappers.getMapper(EmployeeEntityMapper.class);
}
