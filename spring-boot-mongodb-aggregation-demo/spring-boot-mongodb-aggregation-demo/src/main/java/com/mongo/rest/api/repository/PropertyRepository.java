package com.mongo.rest.api.repository;

import com.mongo.rest.api.entity.Property;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {

    @Aggregation(pipeline = {
            "{'$match':{'transaction_type':'For Sale'}}",
    })
    public List<Property> findPropertiesForSale();

    @Aggregation(pipeline = {
            "{'$match':{'transaction_type':'For Sale', 'price' : {$gt : 100000}}}",
    })
    public List<Property> findExpensivePropertiesForSale();

    @Aggregation(pipeline = {
            "{'$match':{'transaction_type': ?0, 'price' : {$gt : ?1}}}",
    })
    public List<Property> findPropertiesByTransactionTypeAndPriceGTPositional(String transactionType, int price);

    @Aggregation(pipeline = {
            "{'$match':{'transaction_type': :#{#transactionType}, 'price' : {$gt : :#{#price} } }}",
    })
    public List<Property> findPropertiesByTransactionTypeAndPriceGTNamed(@Param("transactionType") String transactionType, @Param("price") int price);


    @Aggregation(pipeline = {
            "{'$match':{'transaction_type':?0, 'price': {$gt: ?1} } }",
            "{'$sample':{size:?2}}",
            "{'$sort':{'area':-1}}"
    })
    public List<Property> findPropertiesByTransactionTypeAndPriceGT(String transactionType, int price, int sampleSize);

    @Query("{'transaction_type':'For Sale'}")
    public List<Property> findAllProperty();

    @Query("{'propertyType' : ?0, 'price' : ?1}")
    public List<Property> findByPropertyTypeAndPrice(String propertyType, int price);

    @Query("{'propertyType' : :#{#propertyType}, 'price' : :#{#price}}")
    public List<Property> findPropertyByPropertyTypeAndPrice(@Param("propertyType") String propertyType, @Param("price") int price);


    @Aggregation(pipeline = {
            "{'$match':{'transaction_type':?0, 'price': {$gt: ?1} }}",
            "{'$sample':{size:?2}}",
            "{'$sort':{'area':-1}}"
    })
    List<Property> findPropertiesByTransactionTypeAndPriceGTPageable(String transactionType, int price, int sampleSize, Pageable pageable);

    @Query("{'propertyType' : ?0}")
    public List<Property> searchProperty(String propertyType, Pageable pageable);

}