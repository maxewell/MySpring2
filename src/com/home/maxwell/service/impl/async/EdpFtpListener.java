package com.home.maxwell.service.impl.async;

import com.enterprisedt.net.ftp.EventListener;
import com.home.maxwell.service.AsyncStatus;

public class EdpFtpListener implements EventListener{
	protected AsyncStatus status;
	protected long size;

	public void bytesTransferred(String arg0, String arg1, long arg2) {
		// TODO Auto-generated method stub
		
	}

	public void commandSent(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void downloadCompleted(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void downloadStarted(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void replyReceived(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void uploadCompleted(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void uploadStarted(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(AsyncStatus status){
		this.status = status;
	}

	public void setFileFullSize(long size) {
		this.size = size;
	}
}
