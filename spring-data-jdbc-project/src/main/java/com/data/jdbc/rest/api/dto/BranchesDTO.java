package com.data.jdbc.rest.api.dto;

import com.data.jdbc.rest.api.entity.Subject;
import com.data.jdbc.rest.api.entity.SubjectRef;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchesDTO {
    private Long branchId;
    private String branchName;
    private String branchShortName;
    private String description;
    private Set<SubjectRef> subjects = new HashSet<>();

    public void addSubject(Subject subject) {
        subjects.add(new SubjectRef(subject.getSubjectId()));
    }

}