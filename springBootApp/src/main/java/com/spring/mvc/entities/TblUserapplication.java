package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_userapplication database table.
 * 
 */
@Entity
@Table(name="tbl_userapplication")
@NamedQuery(name="TblUserapplication.findAll", query="SELECT t FROM TblUserapplication t")
public class TblUserapplication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userapplicationid;

	private String type;

	//bi-directional many-to-one association to TblEmployee
	@OneToMany(mappedBy="tblUserapplication")
	private List<TblEmployee> tblEmployees;

	//bi-directional many-to-one association to TblUser
	@ManyToOne
	@JoinColumn(name="userid")
	private TblUser tblUser;

	public TblUserapplication() {
	}

	public int getUserApplicationid() {
		return this.userapplicationid;
	}

	public void setUserApplicationid(int userApplicationid) {
		this.userapplicationid = userApplicationid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TblEmployee> getTblEmployees() {
		return this.tblEmployees;
	}

	public void setTblEmployees(List<TblEmployee> tblEmployees) {
		this.tblEmployees = tblEmployees;
	}

	public TblEmployee addTblEmployee(TblEmployee tblEmployee) {
		getTblEmployees().add(tblEmployee);
		tblEmployee.setTblUserapplication(this);

		return tblEmployee;
	}

	public TblEmployee removeTblEmployee(TblEmployee tblEmployee) {
		getTblEmployees().remove(tblEmployee);
		tblEmployee.setTblUserapplication(null);

		return tblEmployee;
	}

	public TblUser getTblUser() {
		return this.tblUser;
	}

	public void setTblUser(TblUser tblUser) {
		this.tblUser = tblUser;
	}

}