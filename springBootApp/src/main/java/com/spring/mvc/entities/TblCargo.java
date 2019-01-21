package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tbl_cargo database table.
 * 
 */
@Entity
@Table(name="tbl_cargo")
@NamedQuery(name="TblCargo.findAll", query="SELECT t FROM TblCargo t")
public class TblCargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cargoid;

	private String destlocation;

	private BigDecimal fee;

	private String sourcelocation;

	private String weight;

	//bi-directional many-to-one association to TblBillofloading
	@OneToMany(mappedBy="tblCargo")
	private List<TblBillofloading> tblBillofloadings;

	//bi-directional many-to-one association to TblCargotype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="typecargotypeid")
	private TblCargotype tblCargotype;

	//bi-directional many-to-one association to TblCompany
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="companyid")
	private TblCompany tblCompany;

	//bi-directional many-to-one association to TblEmployee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emplid")
	private TblEmployee tblEmployee;

	//bi-directional many-to-one association to TblFlight
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="flightid")
	private TblFlight tblFlight;

	//bi-directional many-to-one association to TblShip
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="shipid")
	private TblShip tblShip;

	//bi-directional many-to-one association to TblTrain
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="trainid")
	private TblTrain tblTrain;

	//bi-directional many-to-one association to TblLuggage
	@OneToMany(mappedBy="tblCargo")
	private List<TblLuggage> tblLuggages;

	//bi-directional many-to-one association to TblPerson
	@OneToMany(mappedBy="tblCargo")
	private List<TblPerson> tblPersons;

	public TblCargo() {
	}

	public int getCargoid() {
		return this.cargoid;
	}

	public void setCargoid(int cargoid) {
		this.cargoid = cargoid;
	}

	public String getDestlocation() {
		return this.destlocation;
	}

	public void setDestlocation(String destlocation) {
		this.destlocation = destlocation;
	}

	public BigDecimal getFee() {
		return this.fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getSourcelocation() {
		return this.sourcelocation;
	}

	public void setSourcelocation(String sourcelocation) {
		this.sourcelocation = sourcelocation;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public List<TblBillofloading> getTblBillofloadings() {
		return this.tblBillofloadings;
	}

	public void setTblBillofloadings(List<TblBillofloading> tblBillofloadings) {
		this.tblBillofloadings = tblBillofloadings;
	}

	public TblBillofloading addTblBillofloading(TblBillofloading tblBillofloading) {
		getTblBillofloadings().add(tblBillofloading);
		tblBillofloading.setTblCargo(this);

		return tblBillofloading;
	}

	public TblBillofloading removeTblBillofloading(TblBillofloading tblBillofloading) {
		getTblBillofloadings().remove(tblBillofloading);
		tblBillofloading.setTblCargo(null);

		return tblBillofloading;
	}

	public TblCargotype getTblCargotype() {
		return this.tblCargotype;
	}

	public void setTblCargotype(TblCargotype tblCargotype) {
		this.tblCargotype = tblCargotype;
	}

	public TblCompany getTblCompany() {
		return this.tblCompany;
	}

	public void setTblCompany(TblCompany tblCompany) {
		this.tblCompany = tblCompany;
	}

	public TblEmployee getTblEmployee() {
		return this.tblEmployee;
	}

	public void setTblEmployee(TblEmployee tblEmployee) {
		this.tblEmployee = tblEmployee;
	}

	public TblFlight getTblFlight() {
		return this.tblFlight;
	}

	public void setTblFlight(TblFlight tblFlight) {
		this.tblFlight = tblFlight;
	}

	public TblShip getTblShip() {
		return this.tblShip;
	}

	public void setTblShip(TblShip tblShip) {
		this.tblShip = tblShip;
	}

	public TblTrain getTblTrain() {
		return this.tblTrain;
	}

	public void setTblTrain(TblTrain tblTrain) {
		this.tblTrain = tblTrain;
	}

	public List<TblLuggage> getTblLuggages() {
		return this.tblLuggages;
	}

	public void setTblLuggages(List<TblLuggage> tblLuggages) {
		this.tblLuggages = tblLuggages;
	}

	public TblLuggage addTblLuggage(TblLuggage tblLuggage) {
		getTblLuggages().add(tblLuggage);
		tblLuggage.setTblCargo(this);

		return tblLuggage;
	}

	public TblLuggage removeTblLuggage(TblLuggage tblLuggage) {
		getTblLuggages().remove(tblLuggage);
		tblLuggage.setTblCargo(null);

		return tblLuggage;
	}

	public List<TblPerson> getTblPersons() {
		return this.tblPersons;
	}

	public void setTblPersons(List<TblPerson> tblPersons) {
		this.tblPersons = tblPersons;
	}

	public TblPerson addTblPerson(TblPerson tblPerson) {
		getTblPersons().add(tblPerson);
		tblPerson.setTblCargo(this);

		return tblPerson;
	}

	public TblPerson removeTblPerson(TblPerson tblPerson) {
		getTblPersons().remove(tblPerson);
		tblPerson.setTblCargo(null);

		return tblPerson;
	}

}