package com.cmayorga.spring.graphql.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmayorga.spring.graphql.jpa.dao.entity.Address;
import com.cmayorga.spring.graphql.jpa.dao.entity.Student;
import com.cmayorga.spring.graphql.jpa.dao.entity.Subject;
import com.cmayorga.spring.graphql.jpa.dao.repository.IAddressRepository;
import com.cmayorga.spring.graphql.jpa.dao.repository.IStudentRepository;
import com.cmayorga.spring.graphql.jpa.dao.repository.ISubjectRepository;
import com.cmayorga.spring.graphql.jpa.schema.dto.CreateStudentRequest;
import com.cmayorga.spring.graphql.jpa.schema.dto.CreateSubjectRequest;


@Service
public class StudentServiceImpl implements IStudentService {

	
	@Autowired
	IStudentRepository studentRepo;
	
	@Autowired
	IAddressRepository addressRepo;
	
	@Autowired
	ISubjectRepository subjectRepo;
	
	@Override
	public Student findStudentInfoById(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	

	@Override
	public Student createStudentByMutation(CreateStudentRequest createStudentRequest) {
		
		Student student = new Student(createStudentRequest);
		
		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());
		address = addressRepo.save(address);
		
		student.setAddress(address);
		student = studentRepo.save(student);
		
		List<Subject> subjectListToCreate = new ArrayList<Subject>();
		
		// If the client send subject to save in database for this student
		if(createStudentRequest.getLearningSubjects()!= null) {
			
			for(CreateSubjectRequest createSubjectRequest : createStudentRequest.getLearningSubjects()) {
				Subject subject = new Subject();
				subject.setSubjectName(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);
				
				subjectListToCreate.add(subject);
			}
			
			// First we save the Subjects in Database
			subjectRepo.saveAll(subjectListToCreate);
		}
		
		
		student.setLearningSubjects(subjectListToCreate);

		
		return student;
	}

}
