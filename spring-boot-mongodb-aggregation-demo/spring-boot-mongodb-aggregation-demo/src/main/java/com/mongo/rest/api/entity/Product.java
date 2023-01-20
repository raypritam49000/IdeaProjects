package com.mongo.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "catalog")
@Builder
// orders
public class Product {

    @Id
    private String _id;

    @Field("item")
    private String item;

    @Field("price")
    private int price;

    @Field("ordered")
    private int ordered;

    public Product(String item, int price, int ordered) {
        this.item = item;
        this.price = price;
        this.ordered = ordered;
    }
}
