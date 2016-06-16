package com.TwistWallet.utils;

import java.io.Serializable;
import java.util.List;

import com.TwistWallet.dto.Cart;
import com.TwistWallet.dto.Login;
import com.TwistWallet.dto.OrderDetails;
import com.TwistWallet.dto.Product;
import com.TwistWallet.dto.Seller;
import com.TwistWallet.dto.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_NULL)
public class TwistWalletRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Login login;
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	private User user;
	private Seller seller;
	private Product product;
	private OrderDetails orderDetails;
	private Cart cart;
	private List<Cart> cartList;
	
	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
