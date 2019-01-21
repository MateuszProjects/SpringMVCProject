package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.BillOfLoadingDAO;
import com.spring.mvc.entities.TblBillofloading;

@Transactional
@Repository
public class BillOfLoadingDAOImpl implements BillOfLoadingDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<TblBillofloading> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TblBillofloading t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TblBillofloading t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(TblBillofloading t) {
		// TODO Auto-generated method stub
		
	}
}
