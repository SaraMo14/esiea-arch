package com.esiea.fr.arch.dto;
import java.util.Date;

/**
 * 
 * @author saram
 *
 */

public class UserDTO {
	//private int ID; we don't have to mention it because the User doen't have to know it
	private String firstname;
	private String lastname;
	private Date birthday;
	private String mobile;
	
	public UserDTO(String firstname, String lastname, Date birthday, String mobile) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.birthday=birthday;
		this.mobile=mobile;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLastname() {
		return this.lastname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}

