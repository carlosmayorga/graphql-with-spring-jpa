package com.cmayorga.spring.graphql.jpa.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmayorga.spring.graphql.jpa.schema.dto.CreateStudentRequest;
import com.cmayorga.spring.graphql.jpa.schema.dto.StudentResponse;
import com.cmayorga.spring.graphql.jpa.service.IStudentService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Service
public class Mutation implements GraphQLMutationResolver {
	
	@Autowired
	private IStudentService service;
	
	
	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		
		return new StudentResponse(service.createStudentByMutation(createStudentRequest));
	}

}
