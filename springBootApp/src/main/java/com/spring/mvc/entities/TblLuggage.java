package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_luggage database table.
 * 
 */
@Entity
@Table(name="tbl_luggage")
@NamedQuery(name="TblLuggage.findAll", query="SELECT t FROM TblLuggage t")
public class TblLuggage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int luggageid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date contentdesc;

	private double weight;

	//bi-directional many-to-one association to TblCargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cargoid")
	private TblCargo tblCargo;

	public TblLuggage() {
	}

	public int getLuggageid() {
		return this.luggageid;
	}

	public void setLuggageid(int luggageid) {
		this.luggageid = luggageid;
	}

	public Date getContentdesc() {
		return this.contentdesc;
	}

	public void setContentdesc(Date contentdesc) {
		this.contentdesc = contentdesc;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public TblCargo getTblCargo() {
		return this.tblCargo;
	}

	public void setTblCargo(TblCargo tblCargo) {
		this.tblCargo = tblCargo;
	}

}