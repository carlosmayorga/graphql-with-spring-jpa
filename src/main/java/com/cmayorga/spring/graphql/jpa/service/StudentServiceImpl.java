package com.cmayorga.spring.graphql.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmayorga.spring.graphql.jpa.dao.entity.Student;
import com.cmayorga.spring.graphql.jpa.dao.repository.IStudentRepository;


@Service
public class StudentServiceImpl implements IStudentService {

	
	@Autowired
	IStudentRepository studentRepo;
	
	@Override
	public Student findStudentInfoById(Long id) {
		return studentRepo.findById(id).orElse(null);
	}

}
