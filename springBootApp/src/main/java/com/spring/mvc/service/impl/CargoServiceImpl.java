package com.spring.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.mvc.dao.CargoDAO;
import com.spring.mvc.entities.TblUserapplication;
import com.spring.mvc.service.CargoService;

public  class CargoServiceImpl implements CargoService{

	@Autowired
	private CargoDAO cargoDAO;
	
	@Override
	public List<TblUserapplication> getAllCargo() {
		return null;
	}

}
