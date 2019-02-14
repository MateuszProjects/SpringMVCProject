package com.spring.mvc.form;

import java.util.Date;

public class LuggageForm {

	private int id;
	private Date contentdesc;
	private double weight;
	
	
	public LuggageForm(int id, Date contentdesc, double weight) {
		super();
		this.id = id;
		this.contentdesc = contentdesc;
		this.weight = weight;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getContentdesc() {
		return contentdesc;
	}
	public void setContentdesc(Date contentdesc) {
		this.contentdesc = contentdesc;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
