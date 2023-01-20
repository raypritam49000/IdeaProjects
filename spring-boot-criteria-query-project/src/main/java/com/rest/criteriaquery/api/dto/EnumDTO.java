package com.rest.criteriaquery.api.dto;

public class EnumDTO {

    private String constant;

    private String value;

    public EnumDTO() {
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EnumDTO{" +
                "constant='" + constant + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
