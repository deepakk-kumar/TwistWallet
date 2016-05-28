package com.TwistWallet.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="user")
@NamedQueries({
	@NamedQuery(name="user.findByEmailAndPassword",query="select u from UserEntity u ,LoginEntity l where u.emailAddress = :emailAddress AND l.password = :password"),
	@NamedQuery(name="user.findByUserId",query="select u from UserEntity u where u.userId=:uId")
})
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
	
	@Column(name="address")
	private String address;
	
	@Column(name="postelCode")
	private int postelCode;
	
	@Column(name="newUser")
	//@Basic(optional = false)
	private Boolean newUser;

	public Boolean getNewUser() {
		return newUser;
	}

	public void setNewUser(Boolean newUser) {
		this.newUser = newUser;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostelCode() {
		return postelCode;
	}

	public void setPostelCode(int postelCode) {
		this.postelCode = postelCode;
	}

	@Column(name="isAdmin")
	private Boolean admin;

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

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString(){
		return ("id "+userId +"firstName "+firstName +"lastName "+lastName
				+"email "+emailAddress +"mob "+mobileNumber);
		
	}
}
