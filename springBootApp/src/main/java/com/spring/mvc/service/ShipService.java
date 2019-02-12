package com.spring.mvc.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.mvc.entities.TblShip;

public interface ShipService extends JpaRepository<TblShip, Integer> {

	


}
