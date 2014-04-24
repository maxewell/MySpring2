package com.home.maxwell.service;

import org.apache.log4j.Logger;

import com.home.maxwell.env.EnvirContext;
import com.home.maxwell.env.FtpRuntime;

public class FtpServiceOut {
	protected static final Logger logger = Logger.getLogger(FtpServiceOut.class);
	protected FtpRuntime env;
	
	protected String ftpServer;
	protected String port;
	protected String userId;
	protected String passwd;
	
	protected void initPropertyFromEnv(){
		ftpServer = env.getFtpServer();
	}
	
	public void doGetService(String dir, String localFile, String remoteFile){
		//PSEUDO CODE:
		initPropertyFromEnv();
		//use ftpService
		logger.info("Use the FtpService:" + ftpServer);
		
	}
	
	public FtpRuntime getEnv() {
		return env;
	}
	public void setEnv(FtpRuntime env) {
		this.env = env;
	}
	
	public String getFtpServer() {
		return ftpServer;
	}
	/*
	public void setFtpServer(String ftpServer) {
		this.ftpServer = ftpServer;
	}
	*/
	public String getPort() {
		return port;
	}
	/*
	public void setPort(String port) {
		this.port = port;
	}
	*/
	
	public String getUserId() {
		return userId;
	}
	/*
	public void setUserId(String userId) {
		this.userId = userId;
	}
	*/
	public String getPasswd() {
		return passwd;
	}
	/*
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	*/
	
	
}
