package com.home.maxwell.domain;

public class InternalError {
	private String errorMsg;

	public InternalError(String msg){
		this.errorMsg = msg;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
