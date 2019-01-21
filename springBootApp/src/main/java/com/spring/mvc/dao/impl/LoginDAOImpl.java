package com.spring.mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.LoginDAO;
import com.spring.mvc.entities.TblUser;


@Transactional
@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TblUser getActiveUser(String userName) {
		TblUser user = new TblUser();
		int ENABLED  = 1;
		String HQL = "SELECT u FROM TblUser u WHERE username =: userName and enabled=: enabled";
		List<?> list = entityManager.createQuery(HQL)
				.setParameter("userName", userName).setParameter("enabled", ENABLED).getResultList();
		
		if(!list.isEmpty()) {
			user = (TblUser) list.get(0);
		}
		
		return user;
	}

	@Override
	public List<TblUser> getAllList() {
		List<TblUser> listUser = new ArrayList<TblUser>();
    	String HQL = "SELECT * FROM TblUser";
    	
    	try {
    		listUser = (List<TblUser>) entityManager.createQuery(HQL).getResultList();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return listUser;
	}

	@Override
	public void save(TblUser t) {
		System.out.println("tbluser: " + t.getPassword());
		System.out.println("tbluser - username: " + t.getUsername());
		
		try {
			entityManager.persist(t);
			System.out.println("Obiekt zapisany" + t);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(TblUser t) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(TblUser t) {
		try {
			entityManager.merge(t);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}	
	
}
