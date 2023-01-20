package com.mongo.rest.api.service;

import com.mongo.rest.api.dto.PropertyDTO;
import com.mongo.rest.api.entity.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyService {
    public PropertyDTO createProperty(PropertyDTO propertyDTO);

    public List<PropertyDTO> createAllProperties(List<PropertyDTO> propertyDTOs);

    public List<PropertyDTO> findPropertiesForSale();

    public List<PropertyDTO> findExpensivePropertiesForSale();

    public List<PropertyDTO> findPropertiesByTransactionTypeAndPriceGTPositional(String transactionType, int price);

    public List<PropertyDTO> findPropertiesByTransactionTypeAndPriceGTNamed(String transactionType, int price);

    public List<PropertyDTO> findPropertiesByTransactionTypeAndPriceGT(String transactionType, int price, int sampleSize);

    public List<PropertyDTO> findAllProperty();

    public List<PropertyDTO> findByPropertyTypeAndPrice(String propertyType, int price);

    public List<PropertyDTO> findPropertyByPropertyTypeAndPrice(@Param("author") String propertyType, @Param("price") int price);

    public List<PropertyDTO> findPropertiesByTransactionTypeAndPriceGTPageable(String transactionType, int price, int sampleSize, Pageable pageable);

    public List<PropertyDTO> searchProperty(String propertyType, Pageable pageable);
}
