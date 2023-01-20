package com.mongo.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ComponentDTO implements Serializable {

    private String _id;

    private String stock_item;

    private String warehouse;

    private int instock;

    private String productId;;

    public ComponentDTO(String stock_item, String warehouse, int instock) {
        this.stock_item = stock_item;
        this.warehouse = warehouse;
        this.instock = instock;
    }
}
