package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.CartoTypeDAO;
import com.spring.mvc.entities.TblCargotype;

@Transactional
@Repository
public class CargoTypeDAOImpl implements CartoTypeDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblCargotype> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblCargotype t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblCargotype t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblCargotype t) {
		// TODO Auto-generated method stub
		
	}




}
