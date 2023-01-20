package com.mongo.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertySearchParameters {
    private String transactionType;
    private int price;
    private int sampleSize;
    private int pageNumber;
    private int pageSize;
}
