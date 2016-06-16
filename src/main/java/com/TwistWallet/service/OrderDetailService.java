package com.TwistWallet.service;

import com.TwistWallet.utils.TwistWalletRequest;
import com.TwistWallet.utils.TwistWalletResponse;

public interface OrderDetailService {
	public TwistWalletResponse placeOrder(TwistWalletRequest request);
	public TwistWalletResponse addToCart(TwistWalletRequest request);
	public TwistWalletResponse getCart(TwistWalletRequest request);
	public TwistWalletResponse deleteFromCart(int cartId);
}
