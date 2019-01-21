package com.spring.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.AccountDAO;
import com.spring.mvc.entities.TblUserapplication;
import com.spring.mvc.service.AccountService;

@Service
public class AccountServiceImpl  implements AccountService{

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public List<TblUserapplication> getAllAccount() {
		return accountDAO.getAllList();
	}

}
