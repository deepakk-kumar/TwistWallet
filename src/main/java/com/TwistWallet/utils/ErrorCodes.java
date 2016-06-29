package com.TwistWallet.utils;

public enum ErrorCodes {

	EMAIL_ALREADY_EXISTS(101,"Email id already exists"),
	EMAIL_NOT_EXISTS(102,"Email id not exists");
	
	private int number;
	private String desc;
	
	ErrorCodes(int number,String desc){
		this.number=number;
		this.desc=desc;
	}
	
	public int getResultCode(){
		return this.number;
	}
	
	public String getDesc(){
		return this.desc;
	}
}
