package com.cmayorga.spring.graphql.jpa.schema.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmayorga.spring.graphql.jpa.dao.entity.Subject;
import com.cmayorga.spring.graphql.jpa.schema.dto.utils.Utils;
import com.coxautodev.graphql.tools.GraphQLResolver;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {
	
	@Autowired
	Utils u;
	
	// GraphQL call this method implicit way, because we use the same name, only add get
	public List<SubjectResponse> getLearningSubjects (StudentResponse studentResponse, LearningSubjectsFilter learningSubjectsFilter) {
		
		List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
		
		if (studentResponse.getStudent().getLearningSubjects() != null) {
			for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
				
				if (learningSubjectsFilter.name().contains(LearningSubjectsFilter.ALL.toString())) {
					learningSubjects.add(new SubjectResponse(subject));
				} else {					
					if (learningSubjectsFilter.name().equalsIgnoreCase(u.removeSpacesFromDb(subject.getSubjectName().toString()))) {					
						learningSubjects.add(new SubjectResponse(subject));
					} 
				}
					
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
