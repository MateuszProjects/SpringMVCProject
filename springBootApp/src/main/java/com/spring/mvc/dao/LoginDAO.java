package com.spring.mvc.dao;


import com.spring.mvc.entities.TblUser;

public interface LoginDAO extends GeneralDAO<TblUser> {
	public abstract TblUser getActiveUser(String userName);
}
