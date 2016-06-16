package com.TwistWallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TwistWallet.service.OrderDetailService;
import com.TwistWallet.utils.TwistWalletRequest;
import com.TwistWallet.utils.TwistWalletResponse;

@Controller
public class orderController {

	@Autowired
	OrderDetailService orderDetailImpl;
	
	@RequestMapping(value="/placeOrder", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody TwistWalletResponse placeOrder(@RequestBody TwistWalletRequest request){
		return orderDetailImpl.placeOrder(request); 
	}
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody TwistWalletResponse addToCart(@RequestBody TwistWalletRequest request){
		return orderDetailImpl.addToCart(request); 
	}
	
	@RequestMapping(value="/getCart", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody TwistWalletResponse getCart(@RequestBody TwistWalletRequest request){
		return orderDetailImpl.getCart(request); 
	}
	
	@RequestMapping(value="/deleteFromCart", method=RequestMethod.GET,produces="application/json")
	public @ResponseBody TwistWalletResponse getCart(@RequestParam(value="cartId")int cartId){
		return orderDetailImpl.deleteFromCart(cartId); 
	}
}
