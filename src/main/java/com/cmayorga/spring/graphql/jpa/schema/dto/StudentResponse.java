package com.cmayorga.spring.graphql.jpa.schema.dto;

import java.util.List;

import com.cmayorga.spring.graphql.jpa.dao.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

	public StudentResponse(Student student) {
		
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
		
		// this is for internal handle. Don't put into schema
		this.student = student;
	}

	
	private long id;

	private String firstName;

	private String lastName;

	private String email;
	
	private String street;

	private String city;
	
	private List<SubjectResponse> learningSubjects;
	
	// this is for internal handle. Don't put into schema
	private Student student;
}
