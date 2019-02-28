package com.spring.mvc.form;

public class PersonForm {

	private Integer id;
	private Integer cargoId;
	private String name;
	private String surname;
	private String email;
	
	public PersonForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonForm(String name, String surname, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCargoId() {
		return cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}
	
	
}
