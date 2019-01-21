package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.ShipDAO;
import com.spring.mvc.entities.TblShip;

@Transactional
@Repository
public class ShipDAOImpl implements ShipDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblShip> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblShip t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblShip t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblShip t) {
		// TODO Auto-generated method stub
		
	}
}
