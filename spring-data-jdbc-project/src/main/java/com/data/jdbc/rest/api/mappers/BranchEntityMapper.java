package com.data.jdbc.rest.api.mappers;

import com.data.jdbc.rest.api.dto.BranchDTO;
import com.data.jdbc.rest.api.entity.Branch;
import com.data.jdbc.rest.api.mappers.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BranchEntityMapper extends BaseMapper<BranchDTO, Branch> {
    BranchEntityMapper INSTANCE = Mappers.getMapper(BranchEntityMapper.class);
}
