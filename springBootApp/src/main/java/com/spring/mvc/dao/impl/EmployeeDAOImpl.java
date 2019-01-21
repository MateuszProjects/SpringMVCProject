package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.EmployeeDAO;
import com.spring.mvc.entities.TblEmployee;

@Transactional
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblEmployee> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblEmployee t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblEmployee t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblEmployee t) {
		// TODO Auto-generated method stub
		
	}
	
}
