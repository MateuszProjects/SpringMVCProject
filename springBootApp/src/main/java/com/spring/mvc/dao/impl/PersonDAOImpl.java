package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.PersonDAO;
import com.spring.mvc.entities.TblPerson;

@Transactional
@Repository
public class PersonDAOImpl implements PersonDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblPerson> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblPerson t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblPerson t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblPerson t) {
		// TODO Auto-generated method stub
		
	}
}
