package com.spring.mvc.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_users database table.
 * 
 */
@Entity
@Table(name="tbl_users")
@NamedQuery(name="TblUser.findAll", query="SELECT t FROM TblUser t")
public class TblUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;

	private String country;

	private int enabled;

	@Column(name="full_name")
	private String fullName;

	private String password;

	private String role;

	private String username;

	//bi-directional many-to-one association to TblUserapplication
	@OneToMany(mappedBy="tblUser")
	private List<TblUserapplication> tblUserapplications;

	public TblUser() {
	}

	public int getUserId() {
		return this.userid;
	}

	public void setUserId(int userId) {
		this.userid = userId;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<TblUserapplication> getTblUserapplications() {
		return this.tblUserapplications;
	}

	public void setTblUserapplications(List<TblUserapplication> tblUserapplications) {
		this.tblUserapplications = tblUserapplications;
	}

	public TblUserapplication addTblUserapplication(TblUserapplication tblUserapplication) {
		getTblUserapplications().add(tblUserapplication);
		tblUserapplication.setTblUser(this);

		return tblUserapplication;
	}

	public TblUserapplication removeTblUserapplication(TblUserapplication tblUserapplication) {
		getTblUserapplications().remove(tblUserapplication);
		tblUserapplication.setTblUser(null);

		return tblUserapplication;
	}

}