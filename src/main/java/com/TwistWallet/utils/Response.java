package com.TwistWallet.utils;

public enum Response {
	SUCCESS(1,"Success"),FAILURE(0,"Failure");
	
	private int resultCode;
	private String resultDesc;
	
	private Response(int code,String desc) {
		// TODO Auto-generated constructor stub
		this.resultCode = code;
		this.resultDesc = desc;
	}
	
	public int getResultCode(){
		return this.resultCode;
	}
	
	public String getDesc(){
		return this.resultDesc;
	}
}
