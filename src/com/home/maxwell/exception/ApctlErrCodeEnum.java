package com.home.maxwell.exception;

public enum ApctlErrCodeEnum {
	ERROR_1_00_1_001(1001001),
	ERROR_5_00_1_001(5001001);
	
	private long apctlError;
	ApctlErrCodeEnum(long code){
		this.apctlError = code;
	}
	
	public String toString(){
		switch(this) {
		case ERROR_1_00_1_001:
			return "1001001";
		case ERROR_5_00_1_001:
			return "5001001";
		default:
			return "ERROR_NOT_DEFINE";
		}
	}
}
