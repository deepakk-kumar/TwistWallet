package com.TwistWallet.utils;

import java.util.List;

import com.TwistWallet.dto.Cart;
import com.TwistWallet.dto.Login;
import com.TwistWallet.dto.Product;
import com.TwistWallet.dto.Seller;
import com.TwistWallet.dto.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(value=Include.NON_NULL)
public class TwistWalletResponse {

	private String resultDesc;
	private int resultCode;
	public User user;
	private Seller seller;
	private Cart cart;
	private List<Product> product;
	private List<Cart> cartList;
	private Login login;
	
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public List<Cart> getCartList() {
		return cartList;
	}
	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public String getResultDesc() {
		return resultDesc;
	}
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
