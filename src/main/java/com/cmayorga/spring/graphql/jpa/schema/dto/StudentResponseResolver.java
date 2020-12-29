package com.cmayorga.spring.graphql.jpa.schema.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cmayorga.spring.graphql.jpa.dao.entity.Subject;
import com.coxautodev.graphql.tools.GraphQLResolver;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {
	
	// GraphQL call this method implicit way, because we use the same name, only add get
	public List<SubjectResponse> getLearningSubjects (StudentResponse studentResponse) {
		
		List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
		
		if (studentResponse.getStudent().getLearningSubjects() != null) {
			for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}
		return learningSubjects;
	}
	
	
	/* This is for show how resolver works internally
	 * and probe that we can use resolver to some business logic
	 */
	public String getFullName (StudentResponse studentResponse) {
		
		return studentResponse.getFirstName() +' '+ studentResponse.getLastName();
	}

}
