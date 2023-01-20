package com.mongo.rest.api.dto;

public class PropertyDTO {

    private String id;
    private int price;
    private int area;
    private String propertyType;
    private String transactionType;

    public PropertyDTO() {
    }

    public PropertyDTO(int price, int area, String propertyType, String transactionType) {
        this.price = price;
        this.area = area;
        this.propertyType = propertyType;
        this.transactionType = transactionType;
    }

    public PropertyDTO(String id, int price, int area, String propertyType, String transactionType) {
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
        return "PropertyDTO{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", propertyType='" + propertyType + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
