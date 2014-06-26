package com.home.maxwell.service;

import com.enterprisedt.net.ftp.EventListener;

public interface FtpEventListener extends EventListener{
	public void setJobSize(int length);
	public void setJobIndex(int i);
	public void setFileSize(long size);
	public void setAsyncStatus(AsyncStatus status);
	

}
