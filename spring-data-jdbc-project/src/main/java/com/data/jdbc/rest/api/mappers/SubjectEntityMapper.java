package com.data.jdbc.rest.api.mappers;

import com.data.jdbc.rest.api.dto.SubjectDTO;
import com.data.jdbc.rest.api.entity.Subject;
import com.data.jdbc.rest.api.mappers.base.BaseMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectEntityMapper extends BaseMapper<SubjectDTO, Subject> {
    SubjectEntityMapper INSTANCE = Mappers.getMapper(SubjectEntityMapper.class);
}
