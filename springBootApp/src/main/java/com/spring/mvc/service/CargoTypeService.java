package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.entities.TblCargotype;

public interface CargoTypeService extends JpaRepository<TblCargotype, Integer>{

}
