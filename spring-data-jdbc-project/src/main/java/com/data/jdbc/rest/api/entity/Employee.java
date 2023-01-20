package com.data.jdbc.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("EMPLOYEE")
public class Employee {
    @Id
    private int id;
    private String name;
    private String salary;
    private String email;

    public Employee(String name, String salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email = email;
    }
}
