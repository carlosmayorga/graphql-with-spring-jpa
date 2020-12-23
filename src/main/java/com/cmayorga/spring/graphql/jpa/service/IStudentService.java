package com.cmayorga.spring.graphql.jpa.service;


import com.cmayorga.spring.graphql.jpa.dao.entity.Student;

public interface IStudentService {
	
	Student findStudentInfoById(Long id);
}
