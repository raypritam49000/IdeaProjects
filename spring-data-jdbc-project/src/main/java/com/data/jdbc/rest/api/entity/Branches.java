package com.data.jdbc.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("BRANCHES")
public class Branches {

    @Id
    private Long branchId;

    private String branchName;

    @Column("BRANCH_SHORT_NAME")
    private String branchShortName;

    private String description;

    @MappedCollection(idColumn = "BRANCH_ID")
    private Set<SubjectRef> subjects = new HashSet<>();

    public void addSubject(Subject subject) {
        subjects.add(new SubjectRef(subject.getSubjectId()));
    }

}