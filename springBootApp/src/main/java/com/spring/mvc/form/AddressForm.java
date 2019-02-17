package com.spring.mvc.form;

public class AddressForm {

	private Integer id;
	private String street;
	private int number;
	private String zipcode;
	private String privince;
	private String region;
	
	public AddressForm() {
		super();
	}

	public AddressForm(String street, int number, String zipcode, String privince, String region) {
		super();
		this.street = street;
		this.number = number;
		this.zipcode = zipcode;
		this.privince = privince;
		this.region = region;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPrivince() {
		return privince;
	}

	public void setPrivince(String privince) {
		this.privince = privince;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
