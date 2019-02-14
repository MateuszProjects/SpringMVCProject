package com.spring.mvc.form;

public class CompanyForm {
	private String companyname;

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
