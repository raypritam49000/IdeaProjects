package com.flayway.migration.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDto {
    private String id;
    private String name;
    private String city;
    private String email;
    private Double salary;
}
