package com.spring.mvc.service.impl;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.LoginDAO;
import com.spring.mvc.entities.TblUser;
import com.spring.mvc.model.UserForm;
import com.spring.mvc.service.LoginService;


@Service
public class LoginServiceImpl implements UserDetailsService, LoginService {

	@Autowired
	private LoginDAO loginDAO;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TblUser tblUser = loginDAO.getActiveUser(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(tblUser.getRole());
		User user = new User(tblUser.getUsername(),tblUser.getPassword(),Arrays.asList(authority));
		UserDetails userDetails = (UserDetails)user; 
		return userDetails;
	}

	@Override
	public void save(UserForm userForm) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		TblUser tbluser = new TblUser();
		
		tbluser.setEnabled(1);
		tbluser.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
		tbluser.setFullName(userForm.getFullname());
		tbluser.setUsername(userForm.getUsername());
		tbluser.setCountry(userForm.getCountry());
		tbluser.setRole("ROLE_USER");
		
		loginDAO.save(tbluser);
	}	
}
