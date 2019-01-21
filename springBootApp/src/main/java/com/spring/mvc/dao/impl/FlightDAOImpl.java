package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.FlightDAO;
import com.spring.mvc.entities.TblFlight;

@Transactional
@Repository
public class FlightDAOImpl implements FlightDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblFlight> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblFlight t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblFlight t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblFlight t) {
		// TODO Auto-generated method stub
		
	}
	
	
}
