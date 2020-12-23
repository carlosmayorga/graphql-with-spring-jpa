package com.cmayorga.spring.graphql.jpa.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cmayorga.spring.graphql.jpa.schema.dto.StudentResponse;
import com.cmayorga.spring.graphql.jpa.service.IStudentService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	private IStudentService service;
	
	public StudentResponse student(Long id) {
		
		return new StudentResponse(service.findStudentInfoById(id));
		
	}

}
