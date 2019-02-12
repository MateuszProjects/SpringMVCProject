package com.spring.mvc.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.spring.mvc.entities.TblUserapplication;

public interface AccountService {
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
	 public abstract List<TblUserapplication> getAllAccount();
}
