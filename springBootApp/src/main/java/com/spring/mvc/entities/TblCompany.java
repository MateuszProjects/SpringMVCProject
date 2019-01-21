package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_company database table.
 * 
 */
@Entity
@Table(name="tbl_company")
@NamedQuery(name="TblCompany.findAll", query="SELECT t FROM TblCompany t")
public class TblCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyid;

	private String companyname;

	//bi-directional many-to-one association to TblCargo
	@OneToMany(mappedBy="tblCompany")
	private List<TblCargo> tblCargos;

	public TblCompany() {
	}

	public int getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public List<TblCargo> getTblCargos() {
		return this.tblCargos;
	}

	public void setTblCargos(List<TblCargo> tblCargos) {
		this.tblCargos = tblCargos;
	}

	public TblCargo addTblCargo(TblCargo tblCargo) {
		getTblCargos().add(tblCargo);
		tblCargo.setTblCompany(this);

		return tblCargo;
	}

	public TblCargo removeTblCargo(TblCargo tblCargo) {
		getTblCargos().remove(tblCargo);
		tblCargo.setTblCompany(null);

		return tblCargo;
	}

}