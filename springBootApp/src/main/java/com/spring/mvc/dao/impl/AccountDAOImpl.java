package com.spring.mvc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dao.AccountDAO;
import com.spring.mvc.entities.TblUserapplication;

@Transactional
@Repository
public class AccountDAOImpl implements AccountDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<TblUserapplication> getAllList() {
		String HQL = "FROM TblUserapplication as t ORDER BY t.userapplicationid";
		return (List<TblUserapplication>) entityManager.createQuery(HQL).getResultList();
	}

	@Override
	public void save(TblUserapplication t) {
		entityManager.persist(t);
	}

	@Override
	public void delete(TblUserapplication t) {
		entityManager.remove(t);
	}

	@Override
	public void update(TblUserapplication t) {
		entityManager.merge(t);
	}

}
