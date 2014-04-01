package com.home.maxwell.env;

public enum EnvironType {
	ENVIR_DE(0),
	ENVIR_SI(1),
	ENVIR_WB(2);
	
	int envirtype;
	
	EnvironType(int i){
		this.envirtype = i;
	}
	
	public String toString(){
		switch(this) {
		case ENVIR_DE:
			return "DE";
		case ENVIR_SI:
			return "SI";
		case ENVIR_WB:
			return "WB";
		default:
			return "TYPE_NOT_DEFINE";
		}
	}
}
