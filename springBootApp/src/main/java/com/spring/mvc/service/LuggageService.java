package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.entities.TblLuggage;

public interface LuggageService extends JpaRepository<TblLuggage, Integer>{

}
