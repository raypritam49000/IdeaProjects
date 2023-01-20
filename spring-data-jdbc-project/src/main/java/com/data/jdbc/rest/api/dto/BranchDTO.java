package com.data.jdbc.rest.api.dto;

import com.data.jdbc.rest.api.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {
    private int branchId;
    private String branchName;
    private String branchShortName;
    private String description;

    private Set<Student> students;

    public BranchDTO(String branchName, String branchShortName, String description) {
        this.branchName = branchName;
        this.branchShortName = branchShortName;
        this.description = description;
    }
}