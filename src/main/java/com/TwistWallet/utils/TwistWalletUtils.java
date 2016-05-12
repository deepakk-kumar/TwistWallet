package com.TwistWallet.utils;

import java.util.Random;

public class TwistWalletUtils {

	public static String getPassword(String email){
		Random r = new Random();
		String snum="";
		if(email != null && email.length() > 6){
		for (int idx = 1; idx <= 3; ++idx){
		      int randomInt = r.nextInt(10);
		       snum = snum.concat(String.valueOf(randomInt));
		    }
		String b[] = email.split("@");
		String name = b[0].substring(0,3);
		String domain = b[1].substring(0,3);
		System.out.println(domain.concat(snum).concat(name));		
		return domain.concat(snum).concat(name);	
	}
	else{
		return "TwistWallet123";
	}
	}}
