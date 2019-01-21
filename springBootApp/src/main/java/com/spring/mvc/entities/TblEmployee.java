package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_employee database table.
 * 
 */
@Entity
@Table(name="tbl_employee")
@NamedQuery(name="TblEmployee.findAll", query="SELECT t FROM TblEmployee t")
public class TblEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int emplid;

	private String name;

	private String surname;

	//bi-directional many-to-one association to TblAddress
	@OneToMany(mappedBy="tblEmployee")
	private List<TblAddress> tblAddresses;

	//bi-directional many-to-one association to TblCargo
	@OneToMany(mappedBy="tblEmployee")
	private List<TblCargo> tblCargos;

	//bi-directional many-to-one association to TblUserapplication
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userapplicationid")
	private TblUserapplication tblUserapplication;

	public TblEmployee() {
	}

	public int getEmplid() {
		return this.emplid;
	}

	public void setEmplid(int emplid) {
		this.emplid = emplid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<TblAddress> getTblAddresses() {
		return this.tblAddresses;
	}

	public void setTblAddresses(List<TblAddress> tblAddresses) {
		this.tblAddresses = tblAddresses;
	}

	public TblAddress addTblAddress(TblAddress tblAddress) {
		getTblAddresses().add(tblAddress);
		tblAddress.setTblEmployee(this);

		return tblAddress;
	}

	public TblAddress removeTblAddress(TblAddress tblAddress) {
		getTblAddresses().remove(tblAddress);
		tblAddress.setTblEmployee(null);

		return tblAddress;
	}

	public List<TblCargo> getTblCargos() {
		return this.tblCargos;
	}

	public void setTblCargos(List<TblCargo> tblCargos) {
		this.tblCargos = tblCargos;
	}

	public TblCargo addTblCargo(TblCargo tblCargo) {
		getTblCargos().add(tblCargo);
		tblCargo.setTblEmployee(this);

		return tblCargo;
	}

	public TblCargo removeTblCargo(TblCargo tblCargo) {
		getTblCargos().remove(tblCargo);
		tblCargo.setTblEmployee(null);

		return tblCargo;
	}

	public TblUserapplication getTblUserapplication() {
		return this.tblUserapplication;
	}

	public void setTblUserapplication(TblUserapplication tblUserapplication) {
		this.tblUserapplication = tblUserapplication;
	}

}