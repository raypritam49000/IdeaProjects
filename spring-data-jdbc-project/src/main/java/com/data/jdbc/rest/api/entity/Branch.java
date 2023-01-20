package com.data.jdbc.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("BRANCH")
public class Branch {
    @Id
    private int branchId;
    private String branchName;
    private String branchShortName;
    private String description;

    @MappedCollection(keyColumn = "BRANCH_ID", idColumn = "BRANCH_ID")
    private Set<Student> students;

    public Branch(String branchName, String branchShortName, String description) {
        this.branchName = branchName;
        this.branchShortName = branchShortName;
        this.description = description;
    }
}