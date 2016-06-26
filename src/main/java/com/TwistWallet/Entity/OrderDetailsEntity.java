package com.TwistWallet.Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import com.TwistWallet.dto.Seller;
import com.TwistWallet.dto.User;

@Entity
@Table(name="OrderDetails")
public class OrderDetailsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderId")
	private int orderId;
	
	@OneToOne
	@JoinColumn(name="userId")
	private UserEntity user;
	
	//@OneToOne
//	@JoinColumn(name="sellerId")
	//private SellerEntity seller;
	
	@Column(name="status")
	@Basic(optional = false)
	private String orderStatus;
	
	@Column(name="details")
	private String orderInfo;
		
	@Column(name="amount")
	@Basic(optional = false)
	private String amount;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

/*	public SellerEntity getSeller() {
		return seller;
	}

	public void setSeller(SellerEntity seller) {
		this.seller = seller;
	}*/

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDetails() {
		return orderInfo;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderInfo = orderDetails;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString(){
		return ("orderId "+orderId +"user "+user +"Amount "+amount
				+"seller " +"orderStatus "+orderStatus);
		
	}
}
