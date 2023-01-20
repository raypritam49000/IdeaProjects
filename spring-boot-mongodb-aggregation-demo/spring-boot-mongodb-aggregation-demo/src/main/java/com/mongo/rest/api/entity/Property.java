package com.mongo.rest.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "property")
public class Property {

    @Id
    private String id;
    @Field("price")
    private int price;
    @Field("area")
    private int area;
    @Field("property_type")
    private String propertyType;
    @Field("transaction_type")
    private String transactionType;

    public Property() {
    }

    public Property(int price, int area, String propertyType, String transactionType) {
        this.price = price;
        this.area = area;
        this.propertyType = propertyType;
        this.transactionType = transactionType;
    }

    public Property(String id, int price, int area, String propertyType, String transactionType) {
        this.id = id;
        this.price = price;
        this.area = area;
        this.propertyType = propertyType;
        this.transactionType = transactionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", propertyType='" + propertyType + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}