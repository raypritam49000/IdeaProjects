package com.mongo.rest.api.repository;

import com.mongo.rest.api.entity.Product;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Aggregation(pipeline = {
            "{ '$lookup' : { 'from' : 'catalog', 'let' : { 'order_item' : '$item' , 'order_qty' : '$ordered' }, 'pipeline' : [ { '$match' : { '$expr' : { '$and' : [ { '$eq' : ['$stock_item', '$$order_item' ] }, { '$gte' : ['$instock', '$$order_qty'] }] }}} , { '$project' : { 'stock_item' : 1 , '_id' : 1 } } ], 'as' : 'stockdata' }}"
    })
    public List<Object> findAllProducts();

    @Query("{id :?0}")
        //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
    Optional<Product> getProductById(String id);

    @Query("{price : {$lt: ?0}}")
        // SQL Equivalent : SELECT * FROM BOOK where pages<?
        //@Query("{ price : { $gte: ?0 } }")                        // SQL Equivalent : SELECT * FROM BOOK where pages>=?
        //@Query("{ price : ?0 }")                                      // SQL Equivalent : SELECT * FROM BOOK where pages=?
    List<Product> getProductsByPages(int price);


    @Query("{item : ?0}")
        // SQL Equivalent : SELECT * FROM BOOK where author = ?
    List<Product> getProductByItem(String item);


    @Query("{price: ?0, item: ?1}")
        // SQL Equivalent : SELECT * FROM BOOK where author = ? and cost=?
        //@Query("{$and :[{price: ?0},{item: ?1}] }")
    List<Product> getProductsByPriceAndItem(int price, String item);


    @Query("{$or :[{price: ?0},{item: ?1}]}")
        //SQL Equivalent : select count(*) from book where author=? or name=?
    List<Product> getProductsByPriceOrItem(int price, String item);


    @Query(value = "{item: ?0}", count = true)
        //SQL Equivalent : select count(*) from book where author=?
    Integer getProductCountByItem(String item);

    //Sorting
    @Query(value = "{item:?0}", sort = "{price:1}")
    //ASC
    //@Query(value = "{item=?0}", sort= "{name:-1}") //DESC
    List<Product> getProductsByItemSortByPrice(String item);

    //------------------- @Query with Projection ---------------------------------------
    @Query(value = "{pages: ?0}", fields = "{price:1, item:1}")
    // only data of name & author properties will be displayed
    //@Query(value= "{pages: ?0}", fields="{name:1, author:1, cost:1, pages:1}") // will display all properties data
    List<Product> getProductPriceAndItemByPages(Integer pages);


    @Query(value = "{item : ?0}")
        // SQL Equivalent : SELECT * FROM BOOK select * from books where author=?
    List<Product> getAllProductsByItem(String item);

    //------------------MongoDB Regular Expressions--------------------------------------
    @Query("{ item : { $regex : ?0 } }")
    List<Product> getProductsByItemRegEx(String item);


}
