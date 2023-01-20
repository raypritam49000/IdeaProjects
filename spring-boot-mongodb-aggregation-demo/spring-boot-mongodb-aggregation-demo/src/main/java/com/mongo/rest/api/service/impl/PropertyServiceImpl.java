package com.mongo.rest.api.service.impl;

import com.mongo.rest.api.dto.PropertyDTO;
import com.mongo.rest.api.entity.Property;
import com.mongo.rest.api.mapper.PropertyEntityMapper;
import com.mongo.rest.api.repository.PropertyRepository;
import com.mongo.rest.api.service.PropertyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyDTO createProperty(PropertyDTO propertyDTO) {
        Property property = PropertyEntityMapper.INSTANCE.toEntity(propertyDTO);
        return PropertyEntityMapper.INSTANCE.toDto(propertyRepository.save(property));
    }

    @Override
    public List<PropertyDTO> createAllProperties(List<PropertyDTO> propertyDTOs) {
        List<Property> propertyList = PropertyEntityMapper.INSTANCE.toEntityList(propertyDTOs);
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.saveAll(propertyList));
    }

    @Override
    public List<PropertyDTO> findPropertiesForSale() {
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.findPropertiesForSale());
    }

    @Override
    public List<PropertyDTO> findExpensivePropertiesForSale() {
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.findExpensivePropertiesForSale());
    }

    @Override
    public List<PropertyDTO> findPropertiesByTransactionTypeAndPriceGTPositional(String transactionType, int price) {
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.findPropertiesByTransactionTypeAndPriceGTPositional(transactionType, price));
    }

    @Override
    public List<PropertyDTO> findPropertiesByTransactionTypeAndPriceGTNamed(String transactionType, int price) {
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.findPropertiesByTransactionTypeAndPriceGTNamed(transactionType, price));
    }

    @Override
    public List<PropertyDTO> findPropertiesByTransactionTypeAndPriceGT(String transactionType, int price, int sampleSize) {
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.findPropertiesByTransactionTypeAndPriceGT(transactionType, price, sampleSize));
    }

    @Override
    public List<PropertyDTO> findAllProperty() {
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.findAllProperty());
    }

    @Override
    public List<PropertyDTO> findByPropertyTypeAndPrice(String propertyType, int price) {
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.findByPropertyTypeAndPrice(propertyType, price));
    }

    @Override
    public List<PropertyDTO> findPropertyByPropertyTypeAndPrice(String propertyType, int price) {
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.findPropertyByPropertyTypeAndPrice(propertyType, price));
    }


    @Override
    public List<PropertyDTO> findPropertiesByTransactionTypeAndPriceGTPageable(String transactionType, int price, int sampleSize, Pageable pageable) {
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.findPropertiesByTransactionTypeAndPriceGTPageable(transactionType, price, sampleSize, pageable));
    }



    @Override
    public List<PropertyDTO> searchProperty(String propertyType, Pageable pageable) {
        return PropertyEntityMapper.INSTANCE.toDtoList(propertyRepository.searchProperty(propertyType,pageable));
    }
}
