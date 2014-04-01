package com.home.maxwell.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.enterprisedt.net.ftp.FileTransferClient;
import com.home.maxwell.exception.FtpServiceException;
import com.home.maxwell.service.FtpService;

public class EdpFtpServiceImpl implements FtpService{
	protected static final Logger logger = LoggerFactory.getLogger(EdpFtpServiceImpl.class);
	protected FileTransferClient ftpClient; 
	protected boolean active = false;

	public void getFile(String remoteDir, String remoteFileName, String localFileName, boolean isAscii) throws FtpServiceException {
		ftpGetFile(remoteDir, new String[]{remoteFileName}, new String[]{localFileName}, isAscii, true);
	}
	
	public void getFile(String remoteDir, String[] remoteFileName, String[] localFileName, boolean isAscii ) throws FtpServiceException {
		if (remoteFileName.length != localFileName.length){
			throw new FtpServiceException("RemoteFileName[] Length not equal localFileName[] length"); 
		}
		
		ftpGetFile(remoteDir, remoteFileName, localFileName, true, this.active);
	}
	
	public void ftpGetFile(String remoteDir, String[] remoteFileName, String[] localFileName, boolean isAscii, boolean isActive) throws FtpServiceException {
		try{
			if (isActive){
				ftpClient.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.ACTIVE);
			}else{
				ftpClient.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.PASV);
			}
			
			ftpClient.connect();
			if (isAscii){
				ftpClient.setContentType(FTPTransferType.ASCII);
			}else{
				ftpClient.setContentType(FTPTransferType.BINARY);
			}
			
			ftpClient.changeDirectory(remoteDir);
			
			int length = remoteFileName.length;
			for (int i = 0; i < length; i++){
				ftpClient.downloadFile(localFileName[i], remoteFileName[i]);
			}
			
		}catch(Exception e){
			throw new FtpServiceException(e);
		}finally{
			if (ftpClient.isConnected()){
				try {
					ftpClient.disconnect();
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

	public void sendFile(String remoteDir, String remoteFileName, String localFileName, boolean isAscii) throws FtpServiceException {
		ftpSendFile(remoteDir, new String[]{remoteFileName}, new String[]{localFileName}, isAscii, true);		
	}
	
	public void sendFile(String remoteDir, String[] remoteFileName, String[] localFileName,  boolean isAscii) throws FtpServiceException {
		if (remoteFileName.length != localFileName.length){
			throw new FtpServiceException("RemoteFileName[] Length not equal localFileName[] length"); 
		}
		
		ftpSendFile(remoteDir, remoteFileName, localFileName, isAscii, true);
	}

	public void ftpSendFile(String remoteDir, String[] remoteFileName, String[] localFileName, boolean isAscii, boolean isActive) throws FtpServiceException {
		try{
			if (isActive){
				ftpClient.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.ACTIVE);
			}else{
				ftpClient.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.PASV);
			}
			
			ftpClient.connect();
			if (isAscii){
				ftpClient.setContentType(FTPTransferType.ASCII);
			}else{
				ftpClient.setContentType(FTPTransferType.BINARY);
			}
			
			ftpClient.changeDirectory(remoteDir);
			
			int length = remoteFileName.length;
			for (int i = 0; i < length; i++){
				ftpClient.uploadFile(localFileName[i], remoteFileName[i]);
			}
			
		}catch(Exception e){
			throw new FtpServiceException(e);
		}finally{
			if (ftpClient.isConnected()){
				try {
					ftpClient.disconnect();
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}
	
	public FileTransferClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FileTransferClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
