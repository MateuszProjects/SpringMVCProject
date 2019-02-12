package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dao.LoginDAO;
import com.spring.mvc.entities.TblUser;
import com.spring.mvc.model.UserForm;
import com.spring.mvc.service.LoginService;
import com.spring.mvc.service.ShipService;
@Controller
@Transactional
public class MainController {

	@Autowired
	LoginService loginService;

	
	@ModelAttribute("createuser")
	public UserForm userForm() {
		return new UserForm();
	}
	
	@RequestMapping("/403")
	public String accessDenied() {
		return "/403";
	}
	
	@RequestMapping("/404")
	public String accessDenied404() {
		return "/403";
	}
	
	@GetMapping("/register")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}

	// POST create new user
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String createUser(@ModelAttribute("createuser") UserForm userForm) {
		try {
			loginService.save(userForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
