package com.mongo.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "stock")
@Builder
// warehouse
public class Component implements Serializable {

    @Id
    private String _id;

    @Field("stock_item")
    private String stock_item;

    @Field("warehouse")
    private String warehouse;

    @Field("instock")
    private int instock;

    private String productId;;

    public Component(String stock_item, String warehouse, int instock) {
        this.stock_item = stock_item;
        this.warehouse = warehouse;
        this.instock = instock;
    }
}
