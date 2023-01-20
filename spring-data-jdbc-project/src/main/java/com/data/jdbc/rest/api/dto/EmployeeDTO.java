package com.data.jdbc.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    private String name;
    private String salary;
    private String email;

    public EmployeeDTO(String name, String salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email = email;
    }
}
