package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.CargoDAO;
import com.spring.mvc.entities.TblCargo;

@Transactional
@Repository
public class CargoDAOImpl implements CargoDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblCargo> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblCargo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblCargo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblCargo t) {
		// TODO Auto-generated method stub
		
	}


}
