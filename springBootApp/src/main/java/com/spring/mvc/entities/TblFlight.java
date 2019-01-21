package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_flight database table.
 * 
 */
@Entity
@Table(name="tbl_flight")
@NamedQuery(name="TblFlight.findAll", query="SELECT t FROM TblFlight t")
public class TblFlight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightid;

	private double cargoweight;

	@Column(name="class")
	private String class_;

	private String destination;

	@Temporal(TemporalType.TIMESTAMP)
	private Date flightdate;

	private double price;

	private int seats;

	private String source;

	//bi-directional many-to-one association to TblCargo
	@OneToMany(mappedBy="tblFlight")
	private List<TblCargo> tblCargos;

	public TblFlight() {
	}

	public int getFlightid() {
		return this.flightid;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	public double getCargoweight() {
		return this.cargoweight;
	}

	public void setCargoweight(double cargoweight) {
		this.cargoweight = cargoweight;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFlightdate() {
		return this.flightdate;
	}

	public void setFlightdate(Date flightdate) {
		this.flightdate = flightdate;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeats() {
		return this.seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<TblCargo> getTblCargos() {
		return this.tblCargos;
	}

	public void setTblCargos(List<TblCargo> tblCargos) {
		this.tblCargos = tblCargos;
	}

	public TblCargo addTblCargo(TblCargo tblCargo) {
		getTblCargos().add(tblCargo);
		tblCargo.setTblFlight(this);

		return tblCargo;
	}

	public TblCargo removeTblCargo(TblCargo tblCargo) {
		getTblCargos().remove(tblCargo);
		tblCargo.setTblFlight(null);

		return tblCargo;
	}

}