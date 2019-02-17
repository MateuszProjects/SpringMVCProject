package com.spring.mvc.form;

public class CargoTypeForm {
	
	private Integer id;
	private String cargotypes;

	public CargoTypeForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCargotypes() {
		return cargotypes;
	}

	public void setCargotypes(String cargotypes) {
		this.cargotypes = cargotypes;
	}

	public CargoTypeForm(String cargotypes) {
		super();
		this.cargotypes = cargotypes;
	}

}
