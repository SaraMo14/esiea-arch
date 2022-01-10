package com.esiea.fr.arch.dto;

import java.util.Date;

public class AccountDTO {

	private String username;
	private String password;
	private Date creationDate;
	private long userID;
	private Date endDate;
	private boolean activated;
	private String type;


	public AccountDTO() {
        super();
    }


	public AccountDTO(String username, String password, Date creationDate, long userID, Date endDate, boolean activated,
			String type) {
		super();
		this.username = username;
		this.password = password;
		this.creationDate = creationDate;
		this.userID = userID;
		this.endDate = endDate;
		this.activated = activated;
		this.type = type;
	}


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


	public long getUserID() {
		return userID;
	}


	public void setUserID(long userID) {
		this.userID = userID;
	}


	public Date getEndDate() {
		return endDate;
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
	
	
}

