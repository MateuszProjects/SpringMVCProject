package com.spring.mvc.form;

import java.util.Date;

public class BillOfLoadingForm {

	private Integer id;
	private String value;
	private String datapyment;
	private String payed;
	private boolean billofloadingcol;

	public BillOfLoadingForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDatapyment() {
		return datapyment;
	}

	public void setDatapyment(String datapyment) {
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
