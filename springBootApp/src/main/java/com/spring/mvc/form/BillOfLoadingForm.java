package com.spring.mvc.form;

import java.util.Date;

public class BillOfLoadingForm {

	private Integer id;
	private double value;
	private Date datapyment;
	private String payed;
	private boolean billofloadingcol;
	
	public BillOfLoadingForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillOfLoadingForm(double value, Date datapyment, String payed, boolean billofloadingcol) {
		super();
		this.value = value;
		this.datapyment = datapyment;
		this.payed = payed;
		this.billofloadingcol = billofloadingcol;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Date getDatapyment() {
		return datapyment;
	}
	public void setDatapyment(Date datapyment) {
		this.datapyment = datapyment;
	}
	public String getPayed() {
		return payed;
	}
	public void setPayed(String payed) {
		this.payed = payed;
	}
	public boolean isBillofloadingcol() {
		return billofloadingcol;
	}
	public void setBillofloadingcol(boolean billofloadingcol) {
		this.billofloadingcol = billofloadingcol;
	}
	
	
}
