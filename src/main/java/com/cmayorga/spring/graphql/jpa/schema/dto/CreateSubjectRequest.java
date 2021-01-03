package com.cmayorga.spring.graphql.jpa.schema.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSubjectRequest {

	private String subjectName;
	
	private Double marksObtained;
}
