package com.rest.criteriaquery.api.dto;

import com.rest.criteriaquery.api.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String id;
    private String name;
    private String city;
    private String email;
    private String department;
    private Gender gender;
}
