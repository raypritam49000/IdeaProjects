package com.mongo.rest.api.mapper;

import com.mongo.rest.api.dto.ProductDTO;
import com.mongo.rest.api.entity.Product;
import com.mongo.rest.api.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductEntityMapper extends BaseMapper<ProductDTO, Product> {
    ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);
}
