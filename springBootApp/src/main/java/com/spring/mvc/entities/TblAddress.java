package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_address database table.
 * 
 */
@Entity
@Table(name="tbl_address")
@NamedQuery(name="TblAddress.findAll", query="SELECT t FROM TblAddress t")
public class TblAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressid;

	private int number;

	private int passengeridn;

	private String province;

	private String region;

	private String street;

	private String zipcode;

	//bi-directional many-to-one association to TblPerson
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customeridn")
	private TblPerson tblPerson;

	//bi-directional many-to-one association to TblEmployee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emplid")
	private TblEmployee tblEmployee;

	public TblAddress() {
	}

	public int getAddressid() {
		return this.addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPassengeridn() {
		return this.passengeridn;
	}

	public void setPassengeridn(int passengeridn) {
		this.passengeridn = passengeridn;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public TblPerson getTblPerson() {
		return this.tblPerson;
	}

	public void setTblPerson(TblPerson tblPerson) {
		this.tblPerson = tblPerson;
	}

	public TblEmployee getTblEmployee() {
		return this.tblEmployee;
	}

	public void setTblEmployee(TblEmployee tblEmployee) {
		this.tblEmployee = tblEmployee;
	}

}