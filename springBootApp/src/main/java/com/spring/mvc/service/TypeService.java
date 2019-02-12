package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.mvc.entities.TblType;

public interface TypeService extends JpaRepository<TblType, Integer>{

}
