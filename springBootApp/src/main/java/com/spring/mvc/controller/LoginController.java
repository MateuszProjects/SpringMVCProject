package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dao.AccountDAO;
import com.spring.mvc.service.AccountService;


@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private AccountService accountService;
	

	
	@GetMapping("/login")
	public ModelAndView login() {
		    ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("custom-login");
		    return modelAndView;
    }
	
	@GetMapping("/secure/list-details")
	public ModelAndView getAllUserTopics() {
		   ModelAndView modelAndView = new ModelAndView();
		   modelAndView.addObject("useraccounts", accountService.getAllAccount());
		   modelAndView.setViewName("application");
		   return modelAndView;
	}
	
	@GetMapping("/secure/account")
	public ModelAndView getAccountDetails() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("account");
			return modelAndView;
	}
	
	@GetMapping("/error")
	public ModelAndView error() {
		    ModelAndView modelAndView = new ModelAndView();
		    String errorMessage= "You are not authorized for the requested data.";
		    modelAndView.addObject("errorMsg", errorMessage);
		    modelAndView.setViewName("error");
		    return modelAndView;
    }
}
