package com.TwistWallet.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="user")
@NamedQuery(name="user.findByEmailAndPassword",query="select u from UserEntity u where u.emailAddress = :emailAddress AND u.password = :password")
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private int userId;
	
	@Column(name="firstName")
	@Basic(optional = false)
	private String firstName;
	
	@Column(name="lastName")
	@Basic(optional = false)
	private String lastName;
	
	@Column(name="emailAddress",unique=true)
	@Basic(optional = false)
	private String emailAddress;
	
	@Column(name="mobileNumber")
	private String mobileNumber;
	
	@Column(name="isAdmin")
	private Boolean admin;
	
	@Column(name="password")
	@Basic(optional = false)
	private String password;

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	
	public String getPassword() {
		return password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString(){
		return ("id "+userId +"firstName "+firstName +"lastName "+lastName
				+"email "+emailAddress +"mob "+mobileNumber);
		
	}
}
