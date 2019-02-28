package com.spring.mvc.form;

public class EmployeeForm {
	private Integer id;
	private String idUserApplication;
	private String name;
	private String surname;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdUserApplication() {
		return idUserApplication;
	}

	public void setIdUserApplication(String idUserApplication) {
		this.idUserApplication = idUserApplication;
	}

}
