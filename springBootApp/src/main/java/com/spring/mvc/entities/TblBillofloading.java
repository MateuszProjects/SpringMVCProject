package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_billofloading database table.
 * 
 */
@Entity
@Table(name="tbl_billofloading")
@NamedQuery(name="TblBillofloading.findAll", query="SELECT t FROM TblBillofloading t")
public class TblBillofloading implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idbillofloading;

	//private short  billofloadingcol;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datapayment;

	private String payed;

	private double value;

	//bi-directional many-to-one association to TblCargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cargoid")
	private TblCargo tblCargo;

	public TblBillofloading() {
	}

	public int getIdbillofloading() {
		return this.idbillofloading;
	}

	public void setIdbillofloading(int idbillofloading) {
		this.idbillofloading = idbillofloading;
	}
/*
	public short getBillofloadingcol() {
		return this.billofloadingcol;
	}

	public void setBillofloadingcol(byte billofloadingcol) {
		this.billofloadingcol = billofloadingcol;
	}
*/
	public Date getDatapayment() {
		return this.datapayment;
	}

	public void setDatapayment(Date datapayment) {
		this.datapayment = datapayment;
	}

	public String getPayed() {
		return this.payed;
	}

	public void setPayed(String payed) {
		this.payed = payed;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public TblCargo getTblCargo() {
		return this.tblCargo;
	}

	public void setTblCargo(TblCargo tblCargo) {
		this.tblCargo = tblCargo;
	}

}