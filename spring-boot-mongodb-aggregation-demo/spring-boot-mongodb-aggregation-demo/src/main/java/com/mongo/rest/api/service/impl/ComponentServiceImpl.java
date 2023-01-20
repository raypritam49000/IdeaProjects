package com.mongo.rest.api.service.impl;

import com.mongo.rest.api.dto.ComponentDTO;
import com.mongo.rest.api.entity.Component;
import com.mongo.rest.api.entity.Product;
import com.mongo.rest.api.mapper.ComponentEntityMapper;
import com.mongo.rest.api.repository.ComponentRepository;
import com.mongo.rest.api.service.ComponentService;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ComponentServiceImpl implements ComponentService {

    private final MongoTemplate mongoTemplate;
    private final MongoOperations mongoOperations;
    private final ComponentRepository componentRepository;

    public ComponentServiceImpl(MongoTemplate mongoTemplate, ComponentRepository componentRepository, MongoOperations mongoOperations) {
        this.mongoTemplate = mongoTemplate;
        this.componentRepository = componentRepository;
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<ComponentDTO> getAllComponentByProduct() {
        Aggregation agg = Aggregation.newAggregation(l -> new Document("$lookup",
                        new Document("from", mongoTemplate.getCollectionName(Product.class))
                                .append("let", new Document("productId", new Document("$toObjectId", "$productId")))
                                .append("pipeline",
                                        Arrays.asList(new Document("$match",
                                                new Document("$expr",
                                                        new Document("$eq", Arrays.asList("$_id", "$$productId"))))))
                                .append("as", "product")),
                Aggregation.unwind("product", Boolean.TRUE));

        AggregationResults<Component> results = mongoTemplate.aggregate(agg,
                mongoTemplate.getCollectionName(Component.class), Component.class);
        List<Component> componentList = results.getMappedResults();
        return ComponentEntityMapper.INSTANCE.toDtoList(componentList);
    }

    @Override
    public List<ComponentDTO> findAllComponentByProduct() {
        return ComponentEntityMapper.INSTANCE.toDtoList(componentRepository.findAllComponentByProduct());
    }

    @Override
    public List<ComponentDTO> findAllComponentByWarehouse(String warehouse) {
        return ComponentEntityMapper.INSTANCE.toDtoList(componentRepository.findAllComponentByWarehouse(warehouse));
    }

    @Override
    public List<String> findAllWarehouse(String warehouse) {
        return componentRepository.findAllWarehouse(warehouse);
    }

    @Override
    public List<String> findAllWarehouses(String warehouse) {
        return componentRepository.findAllWarehouses(warehouse);
    }

    @Override
    public List<String> findAllWarehousesProject(String warehouse) {
        return componentRepository.findAllWarehousesProject(warehouse);
    }

    @Override
    public List<ComponentDTO> findAllComponentByWarehouseWithSorting(String warehouse) {
        return ComponentEntityMapper.INSTANCE.toDtoList(componentRepository.findAllComponentByWarehouseWithSorting(warehouse));
    }

    @Override
    public List<ComponentDTO> findAllComponentList() {
        return ComponentEntityMapper.INSTANCE.toDtoList(componentRepository.findAllComponentList());
    }

    @Override
    public List<ComponentDTO> getAllComponents() {
        return ComponentEntityMapper.INSTANCE.toDtoList(mongoOperations.findAll(Component.class));
    }

    @Override
    public List<ComponentDTO> getComponentById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        List<Component> components = mongoTemplate.find(query, Component.class);
        return ComponentEntityMapper.INSTANCE.toDtoList(components);
    }

}

