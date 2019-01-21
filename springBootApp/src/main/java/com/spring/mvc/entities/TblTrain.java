package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_train database table.
 * 
 */
@Entity
@Table(name="tbl_train")
@NamedQuery(name="TblTrain.findAll", query="SELECT t FROM TblTrain t")
public class TblTrain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int trainid;

	private double cargoweight;

	@Column(name="class")
	private String class_;

	private String destination;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;

	private double price;

	private int seats;

	private String source;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;

	//bi-directional many-to-one association to TblCargo
	@OneToMany(mappedBy="tblTrain")
	private List<TblCargo> tblCargos;

	public TblTrain() {
	}

	public int getTrainid() {
		return this.trainid;
	}

	public void setTrainid(int trainid) {
		this.trainid = trainid;
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

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
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

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public List<TblCargo> getTblCargos() {
		return this.tblCargos;
	}

	public void setTblCargos(List<TblCargo> tblCargos) {
		this.tblCargos = tblCargos;
	}

	public TblCargo addTblCargo(TblCargo tblCargo) {
		getTblCargos().add(tblCargo);
		tblCargo.setTblTrain(this);

		return tblCargo;
	}

	public TblCargo removeTblCargo(TblCargo tblCargo) {
		getTblCargos().remove(tblCargo);
		tblCargo.setTblTrain(null);

		return tblCargo;
	}

}