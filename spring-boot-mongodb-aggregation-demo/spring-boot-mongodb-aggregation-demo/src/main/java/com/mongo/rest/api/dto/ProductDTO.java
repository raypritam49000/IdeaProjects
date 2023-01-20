package com.mongo.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductDTO {

    private String _id;

    private String item;

    private int price;

    private int ordered;

    public ProductDTO(String item, int price, int ordered) {
        this.item = item;
        this.price = price;
        this.ordered = ordered;
    }
}
