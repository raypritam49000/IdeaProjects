package com.data.jdbc.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    private String building;
    private String street;
    private String state;
    private String country;
    private String zipcode;

    public AddressDTO(String building, String street, String state, String country, String zipcode) {
        this.building = building;
        this.street = street;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }
}