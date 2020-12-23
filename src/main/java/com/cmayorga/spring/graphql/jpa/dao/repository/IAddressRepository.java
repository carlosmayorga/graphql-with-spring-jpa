package com.cmayorga.spring.graphql.jpa.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmayorga.spring.graphql.jpa.dao.entity.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {

}
