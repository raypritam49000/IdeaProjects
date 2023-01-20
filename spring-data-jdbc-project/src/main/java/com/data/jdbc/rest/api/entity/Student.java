package com.data.jdbc.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("STUDENT")
public class Student {
    @Id
    private Long id;
    private String contactNo;
    private String firstName;
    private String lastName;

    public Student(String contactNo, String firstName, String lastName) {
        this.contactNo = contactNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}