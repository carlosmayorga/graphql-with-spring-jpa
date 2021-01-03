package com.cmayorga.spring.graphql.jpa.service;


import com.cmayorga.spring.graphql.jpa.dao.entity.Student;
import com.cmayorga.spring.graphql.jpa.schema.dto.CreateStudentRequest;

public interface IStudentService {
	
	Student findStudentInfoById(Long id);
	
	Student createStudentByMutation(CreateStudentRequest createStudentRequest);
}
