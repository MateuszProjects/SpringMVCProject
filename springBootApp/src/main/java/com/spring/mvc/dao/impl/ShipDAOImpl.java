package com.spring.mvc.dao.impl;

import java.util.List;
import java.util.Optional;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TblShip> getAllList() {
		String HQL  = "FROM TblShip as s ORDER BY s.shipid";
		return (List<TblShip>) entityManager.createQuery(HQL).getResultList();
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
