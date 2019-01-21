package com.spring.mvc.dao;

import java.util.List;

public interface GeneralDAO<T> {
	List<T> getAllList();
	void save(T t);
	void delete(T t);
	void update(T t);
}
