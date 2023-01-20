package com.vault.server.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private String id;
    private String name;
    private String city;
    private String email;
    private String salary;
}
