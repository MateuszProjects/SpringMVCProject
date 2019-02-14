package com.spring.mvc.form;

public class CargoTypeForm {
	
	private String cargotypes;

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
