package com.spring.mvc.model;


public class UserForm {

	private String username;
	private String country;
	private String fullname;
	private String password;

	public UserForm() {
	}
	
	public UserForm(String username, String country, String fullname, String password) {
		super();
		this.username = username;
		this.country = country;
		this.fullname = fullname;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
