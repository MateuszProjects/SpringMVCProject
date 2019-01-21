package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.LuggageDAO;
import com.spring.mvc.entities.TblLuggage;

@Transactional
@Repository
public class LuggageDAOImpl implements LuggageDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblLuggage> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblLuggage t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblLuggage t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblLuggage t) {
		// TODO Auto-generated method stub
		
	}
}
