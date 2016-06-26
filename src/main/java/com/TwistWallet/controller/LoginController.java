package com.TwistWallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.TwistWallet.service.LoginSignupService;
import com.TwistWallet.utils.TwistWalletRequest;
import com.TwistWallet.utils.TwistWalletResponse;

@Controller
public class LoginController {

	@Autowired
	LoginSignupService loginSignupImpl;
	
	@RequestMapping(value="/login", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody TwistWalletResponse validate(@RequestBody TwistWalletRequest request ){
		return loginSignupImpl.login(request); 
	}
	
	@RequestMapping(value="/resetPass", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody TwistWalletResponse reset(@RequestBody TwistWalletRequest request ){
		return loginSignupImpl.reset(request); 
	}
	
	@RequestMapping(value="/duplicateEmail", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody TwistWalletResponse duplicateEmail(@RequestBody TwistWalletRequest request ){
		return loginSignupImpl.duplicateEmail(request); 
	}
	
	@RequestMapping(value="/forgotPassword", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public @ResponseBody TwistWalletResponse forgotPassword(@RequestBody TwistWalletRequest request ){
		return loginSignupImpl.forgotPassword(request); 
	}
}
