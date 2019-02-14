package com.spring.mvc.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;

import com.spring.mvc.entities.TblCargo;
import com.spring.mvc.entities.TblUserapplication;

public interface CargoService{
	 @Secured ({"ROLE_ADMIN"})
	 public abstract List<TblUserapplication> getAllCargo();
}
