package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_person database table.
 * 
 */
@Entity
@Table(name="tbl_person")
@NamedQuery(name="TblPerson.findAll", query="SELECT t FROM TblPerson t")
public class TblPerson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerid;

	private String email;

	private String name;

	private String surname;

	//bi-directional many-to-one association to TblAddress
	@OneToMany(mappedBy="tblPerson")
	private List<TblAddress> tblAddresses;

	//bi-directional many-to-one association to TblCargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cargoid")
	private TblCargo tblCargo;

	//bi-directional many-to-one association to TblType
	@OneToMany(mappedBy="tblPerson")
	private List<TblType> tblTypes;

	public TblPerson() {
	}

	public int getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		tblAddress.setTblPerson(this);

		return tblAddress;
	}

	public TblAddress removeTblAddress(TblAddress tblAddress) {
		getTblAddresses().remove(tblAddress);
		tblAddress.setTblPerson(null);

		return tblAddress;
	}

	public TblCargo getTblCargo() {
		return this.tblCargo;
	}

	public void setTblCargo(TblCargo tblCargo) {
		this.tblCargo = tblCargo;
	}

	public List<TblType> getTblTypes() {
		return this.tblTypes;
	}

	public void setTblTypes(List<TblType> tblTypes) {
		this.tblTypes = tblTypes;
	}

	public TblType addTblType(TblType tblType) {
		getTblTypes().add(tblType);
		tblType.setTblPerson(this);

		return tblType;
	}

	public TblType removeTblType(TblType tblType) {
		getTblTypes().remove(tblType);
		tblType.setTblPerson(null);

		return tblType;
	}

}