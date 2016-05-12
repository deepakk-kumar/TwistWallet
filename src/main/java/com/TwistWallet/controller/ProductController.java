package com.TwistWallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TwistWallet.service.ProductService;
import com.TwistWallet.utils.TwistWalletResponse;

@Controller
public class ProductController {

	@Autowired
	 ProductService productServiceImpl;
	
	@RequestMapping(value="/getAllProduct", method=RequestMethod.GET,produces="application/json")
	public @ResponseBody TwistWalletResponse getAllProduct(){
		return productServiceImpl.getAllProducts(); 
	}
	
}
