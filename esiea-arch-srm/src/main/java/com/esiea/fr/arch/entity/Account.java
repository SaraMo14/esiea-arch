package com.esiea.fr.arch.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="USERNAME")
	private String username;
	
	@Column(name ="PASSWORD")
	private String password;
	
	@Column(name ="CREATION_DATE")
	private Date creationDate;
	
	@ManyToOne
    @JoinColumn(name ="USER_ID")
    //@Column(name ="USER_ID")
	private User user;
	
	@Column(name ="END_DATE")
	private Date endDate;
	
	@Column(name ="ACTIVATED")
	private boolean activated;
	
	@Column(name ="TYPE")
	private String type;

	public Account() {
		
	}
	public Account(String username, String password, Date creationDate, User user, Date endDate, boolean activated,
			String type) {
		super();
		this.username = username;
		this.password = password;
		this.creationDate = creationDate;
		this.user = user;
		this.endDate = endDate;
		this.activated = activated;
		this.type = type;
	}

	//getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	
	public Date getEndDate() {
		return endDate;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
