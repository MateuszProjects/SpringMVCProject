package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.entities.TblEmployee;

public interface EmployeeService extends JpaRepository<TblEmployee, Integer>{

}
