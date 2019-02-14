package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.entities.TblCompany;

public interface CompanyService extends JpaRepository<TblCompany, Integer>{

}
