package com.spring.mvc.form;

public class CompanyForm {
	private Integer id;
	private String companyname;
	
	public CompanyForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public CompanyForm(String companyname) {
		super();
		this.companyname = companyname;
	}
	
	
}
