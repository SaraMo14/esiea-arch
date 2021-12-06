package com.esiea.fr.arch.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="USER_ID")
	private long id;
	
	@Column(name ="FIRSTNAME")
	private String firstname;
	
	@Column(name ="LASTNAME")
	private String lastname;
	
	@Column(name ="MOBILE")
	private int mobile;
	
	@Column(name ="BIRTHDAY")
	private Date birthday;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
