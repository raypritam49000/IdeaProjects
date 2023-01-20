package com.data.jdbc.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String contactNo;
    private String firstName;
    private String lastName;

    public StudentDTO(String contactNo, String firstName, String lastName) {
        this.contactNo = contactNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}