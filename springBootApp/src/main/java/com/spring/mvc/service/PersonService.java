package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.entities.TblPerson;

public interface PersonService extends JpaRepository<TblPerson, Integer>{

}
