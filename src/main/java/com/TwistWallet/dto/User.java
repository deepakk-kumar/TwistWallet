package com.TwistWallet.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(value=Include.NON_NULL)
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int userId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private boolean admin;
	private String mobileNumber;
	private Boolean newUser;
	public Boolean getNewUser() {
		return newUser;
	}
	public void setNewUser(Boolean newUser) {
		this.newUser = newUser;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
}
