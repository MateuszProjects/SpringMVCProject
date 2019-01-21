package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.AddressDAO;
import com.spring.mvc.entities.TblAddress;

@Transactional
@Repository
public class AddressDAOImpl implements AddressDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblAddress> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblAddress t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblAddress t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblAddress t) {
		// TODO Auto-generated method stub
		
	}

}
