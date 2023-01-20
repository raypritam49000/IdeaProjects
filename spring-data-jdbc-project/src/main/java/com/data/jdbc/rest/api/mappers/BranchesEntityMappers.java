package com.data.jdbc.rest.api.mappers;

import com.data.jdbc.rest.api.dto.BranchesDTO;
import com.data.jdbc.rest.api.mappers.base.BaseMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchesEntityMappers extends BaseMapper<BranchesDTO,BranchesDTO> {
    BranchesEntityMappers INSTANCE = Mappers.getMapper(BranchesEntityMappers.class);
}
