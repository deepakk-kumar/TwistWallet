package com.TwistWallet.Entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
@NamedQueries({
@NamedQuery(name="cart.findByLoginId",query="select u from CartEntity u where u.login.loginId=:loginId"),
@NamedQuery(name="cart.findByCartId",query="select u from CartEntity u where u.cartId=:cartId")
})
public class CartEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cartId")
	private int cartId;
	
	
	//@Column(name="loginIdd")
	@ManyToOne
	private LoginEntity login;
	
	@ManyToOne
	//@JoinColumn(name="productId")
	private ProductEntity product;
		
	

	public LoginEntity getLogin() {
		return login;
	}

	public void setLogin(LoginEntity login) {
		this.login = login;
	}

	@Column(name="quantity")
	@Basic(optional = false)
	private int quantity;
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString(){
		return ("cartId "+cartId +"login "+login +"Amount "+product
				+"product " +"quantity "+quantity);
		
	}
}
