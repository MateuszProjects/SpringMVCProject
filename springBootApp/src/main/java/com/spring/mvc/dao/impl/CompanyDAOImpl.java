package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.CompanyDAO;
import com.spring.mvc.entities.TblCompany;

@Transactional
@Repository
public class CompanyDAOImpl implements CompanyDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblCompany> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblCompany t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblCompany t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblCompany t) {
		// TODO Auto-generated method stub
		
	}
	
	
}
