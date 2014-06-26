package com.home.maxwell.service.impl.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.FtpService;

public class EdpFtpRunnableImpl extends AbstractRunnableImpl{
	protected static Logger logger = LoggerFactory.getLogger(EdpFtpRunnableImpl.class);
	protected boolean active = false;
	
	protected FtpService ftpService;   
	
	public void doAsync() throws Throwable{
		String method = (String)this.dataMap.get(ConstantKey.FTP_RUN_METHOD);
		String localFile = (String)this.dataMap.get(ConstantKey.FTP_LOCAL_FILE);
		String remoteDir = (String)this.dataMap.get(ConstantKey.FTP_REMOTE_DIR);
		String remoteFile = (String)this.dataMap.get(ConstantKey.FTP_REMOTE_FILE);
		Boolean isAscii = (Boolean)this.dataMap.get(ConstantKey.FTP_TYPE_IS_ASCII);
		
		if (ConstantKey.FTP_RUN_METHOD_GET.equals(method)){
			ftpService.getFile(remoteDir, remoteFile, localFile, isAscii);
		}else if (ConstantKey.FTP_RUN_METHOD_GET.equals(method)){
			ftpService.sendFile(remoteDir, remoteFile, localFile, isAscii);
		}else{
			throw new Exception("is not GET or PUT method");
		}
	}
	
	public FtpService getFtpService() {
		return this.ftpService;
	}

	public void setFtpService(FtpService ftp) {
		this.ftpService = ftp;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
		
	public void setAsyncStatus(AsyncStatus status){
		super.setAsyncStatus(status);
		if (this.ftpService != null){
			this.ftpService.setAsyncStatus(status);
		}
	}
}
