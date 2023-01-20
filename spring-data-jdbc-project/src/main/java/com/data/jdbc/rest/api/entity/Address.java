package com.data.jdbc.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("ADDRESS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private Long id;
    private String building;
    private String street;
    private String state;
    private String country;
    private String zipcode;

    public Address(String building, String street, String state, String country, String zipcode) {
        this.building = building;
        this.street = street;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }
}