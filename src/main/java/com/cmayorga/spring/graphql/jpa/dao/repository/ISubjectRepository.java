package com.cmayorga.spring.graphql.jpa.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmayorga.spring.graphql.jpa.dao.entity.Subject;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long>{

}
