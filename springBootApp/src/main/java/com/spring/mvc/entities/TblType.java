package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_type database table.
 * 
 */
@Entity
@Table(name="tbl_type")
@NamedQuery(name="TblType.findAll", query="SELECT t FROM TblType t")
public class TblType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtype;

	private String type;

	//bi-directional many-to-one association to TblPerson
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerid")
	private TblPerson tblPerson;

	public TblType() {
	}

	public int getIdtype() {
		return this.idtype;
	}

	public void setIdtype(int idtype) {
		this.idtype = idtype;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TblPerson getTblPerson() {
		return this.tblPerson;
	}

	public void setTblPerson(TblPerson tblPerson) {
		this.tblPerson = tblPerson;
	}

}