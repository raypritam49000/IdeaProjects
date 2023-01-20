package com.data.jdbc.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table("BRANCHES_SUBJECT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRef {
	Long subjectId;
}