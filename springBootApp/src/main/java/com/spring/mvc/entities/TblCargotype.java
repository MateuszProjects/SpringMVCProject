package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_cargotype database table.
 * 
 */
@Entity
@Table(name="tbl_cargotype")
@NamedQuery(name="TblCargotype.findAll", query="SELECT t FROM TblCargotype t")
public class TblCargotype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cargotypeid;

	private String cargotypeses;

	//bi-directional many-to-one association to TblCargo
	@OneToMany(mappedBy="tblCargotype")
	private List<TblCargo> tblCargos;

	public TblCargotype() {
	}

	public int getCargotypeid() {
		return this.cargotypeid;
	}

	public void setCargotypeid(int cargotypeid) {
		this.cargotypeid = cargotypeid;
	}

	public String getCargotypeses() {
		return this.cargotypeses;
	}

	public void setCargotypeses(String cargotypeses) {
		this.cargotypeses = cargotypeses;
	}

	public List<TblCargo> getTblCargos() {
		return this.tblCargos;
	}

	public void setTblCargos(List<TblCargo> tblCargos) {
		this.tblCargos = tblCargos;
	}

	public TblCargo addTblCargo(TblCargo tblCargo) {
		getTblCargos().add(tblCargo);
		tblCargo.setTblCargotype(this);

		return tblCargo;
	}

	public TblCargo removeTblCargo(TblCargo tblCargo) {
		getTblCargos().remove(tblCargo);
		tblCargo.setTblCargotype(null);

		return tblCargo;
	}

}