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
@Table(name="seller")
public class SellerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sellerId")
	private int sellerId;
	
	@Column(name="sellerName")
	private String sellerName;
	
	@Column(name="sellerAddress")
	private String sellerAddress;
	
	@Column(name="sellerMobile")
	private String sellerMobile;
	
			
	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	public String getSellerName() {
		return sellerName;
	}


	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}


	public String getSellerAddress() {
		return sellerAddress;
	}


	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}


	public String getSellerMobile() {
		return sellerMobile;
	}


	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}


	@Override
	public String toString(){
		return ("sellerId "+sellerId +"sellerName "+sellerName +"sellerAddress "+sellerAddress
				+"sellerMobile "+sellerMobile);
		
	}
}
