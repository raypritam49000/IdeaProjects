package com.data.jdbc.rest.api.mappers;

import com.data.jdbc.rest.api.dto.StudentDTO;
import com.data.jdbc.rest.api.entity.Student;
import com.data.jdbc.rest.api.mappers.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentEntityMapper extends BaseMapper<StudentDTO, Student> {
    StudentEntityMapper INSTANCE = Mappers.getMapper(StudentEntityMapper.class);
}
