package com.home.maxwell.service;

import com.enterprisedt.net.ftp.EventListener;

public interface FtpEventListener extends EventListener{

	void setJobSize(int length);
	void setJobIndex(int i);
	void setFileSize(long size);

}
