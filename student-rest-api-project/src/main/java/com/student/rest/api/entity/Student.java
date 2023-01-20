package com.student.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String city;
    private String email;
    private String salary;

    public Student(String name, String city, String email, String salary) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.salary = salary;
    }
}
