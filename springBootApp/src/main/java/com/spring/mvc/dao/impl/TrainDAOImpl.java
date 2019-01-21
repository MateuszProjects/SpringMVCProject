package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.TrainDAO;
import com.spring.mvc.entities.TblTrain;

@Transactional
@Repository
public class TrainDAOImpl implements TrainDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblTrain> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblTrain t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblTrain t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblTrain t) {
		// TODO Auto-generated method stub
		
	}
}
