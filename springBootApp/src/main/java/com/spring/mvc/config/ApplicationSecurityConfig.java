package com.spring.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.mvc.service.impl.LoginServiceImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoginServiceImpl loginserviceimpl;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin/secure/**").hasRole("ADMIN")
		.antMatchers("/user/secure/**", "/login/page").hasAnyRole("ADMIN","USER")
		.and().formLogin()
		.loginPage("/user/login")
		.loginProcessingUrl("/app-login")
		.usernameParameter("app_username")
		.passwordParameter("app_password")
		.defaultSuccessUrl("/user/secure/list-details")
		.and().logout()
		.logoutUrl("/app-logout")
		.logoutSuccessUrl("/user/login")
		.and().exceptionHandling()
		.accessDeniedPage("/user/error");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(loginserviceimpl).passwordEncoder(bCryptPasswordEncoder);
	}
	
}
