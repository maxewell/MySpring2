package com.home.maxwell.exception;

public class FtpServiceException extends Throwable{
	
	public FtpServiceException(String msg){
		super(msg);
	}
	
	public FtpServiceException(Throwable e){
		super(e);
	}
}
