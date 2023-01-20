package com.flayway.migration.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Person {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "person_id")
    private String id;
    private String name;
    private String city;
    private String email;
    private Double salary;

    public Person(String name, String city, String email, Double salary) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.salary = salary;
    }
}
