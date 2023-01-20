package com.data.jdbc.rest.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data // lombok
@AllArgsConstructor
@NoArgsConstructor
@Table("SUBJECT")
public class Subject {

	@Id
	private Long subjectId;

	private String subjectDesc;
	private String subjectName;

}