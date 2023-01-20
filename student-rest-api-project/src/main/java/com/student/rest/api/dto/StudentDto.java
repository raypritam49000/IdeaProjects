package com.student.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int id;
    private String name;
    private String city;
    private String email;
    private String salary;

    public StudentDto(String name, String city, String email, String salary) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.salary = salary;
    }
}
