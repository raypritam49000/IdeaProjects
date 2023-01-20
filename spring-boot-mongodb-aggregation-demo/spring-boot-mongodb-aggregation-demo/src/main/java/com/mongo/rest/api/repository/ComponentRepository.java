package com.mongo.rest.api.repository;

import com.mongo.rest.api.entity.Component;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentRepository extends MongoRepository<Component, String> {

    @Aggregation(pipeline = {
            "{ '$lookup' : { 'from' : 'catalog', 'let' : { 'productId' : { '$toObjectId' : '$productId' }}, 'pipeline' : [{ '$match' : { '$expr' : { '$eq' : ['$_id', '$$productId']}}}], 'as' : 'product'}}, { '$unwind' : { 'path' : '$product', 'preserveNullAndEmptyArrays' : true}}"
    })
    public List<Component> findAllComponentByProduct();

    @Aggregation(pipeline = {
            "{ '$match' : { 'warehouse' : ?0 } }"
    })
    public List<Component> findAllComponentByWarehouse(String warehouse);

    @Aggregation(pipeline = {
            "{ '$match' : { 'warehouse' : ?0 } }",
            "{ '$group' : { '_id' : '$warehouse' }}"
    })
    public List<String> findAllWarehouse(String warehouse);

    @Aggregation(pipeline = {
            "{ '$match' : { 'warehouse' : ?0 } }",
            "{ '$group' : { '_id' : '$warehouse' , 'data' : { '$push' : '$$ROOT' } } }"
    })
    public List<String> findAllWarehouses(String warehouse);

    @Aggregation(pipeline = {
            "{ '$match' : { 'warehouse' : ?0 } }",
            "{ '$group' : { '_id' : '$warehouse' , 'data' : { '$push' : '$$ROOT' } } }",
            "{ '$project' : { '_id' : 0 , 'stock_item' : 0 } }"
    })
    public List<String> findAllWarehousesProject(String warehouse);


    @Aggregation(pipeline = {
            "{ '$match' : { 'warehouse' : ?0 } }",
            "{ '$sort' : { 'stock_item' : 1 } }",
            "{ '$limit' : 3 }"
    })
    public List<Component> findAllComponentByWarehouseWithSorting(String warehouse);

    @Aggregation(pipeline = {
            "{ '$match' :  {  'warehouse'  :  'A'  }  } ",
            "{ '$project' :  {  '_id' : 0 , 'stock_item' : 0 } }",
            "{ '$lookup' : { 'from': 'catalog' , 'localField': '_id' , 'foreignField': 'productId' , as: 'courses' } }"
    })
    public List<Component> findAllComponentList();


}
