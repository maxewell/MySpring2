package com.home.maxwell.service.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enterprisedt.net.ftp.EventListener;
import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.enterprisedt.net.ftp.FileTransferClient;
import com.home.maxwell.exception.FtpServiceException;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.FtpEventListener;
import com.home.maxwell.service.FtpService;

public class EdpFtpServiceImpl implements FtpService{
	protected static final Logger logger = LoggerFactory.getLogger(EdpFtpServiceImpl.class);
	protected FileTransferClient ftpClient; 
	protected boolean active = false;
	protected FtpEventListener listener;

	public void getFile(String remoteDir, String remoteFileName, String localFileName) throws FtpServiceException {
		getFile(remoteDir, remoteFileName, localFileName, false);
	}
	
	public void getFile(String remoteDir, String remoteFileName, String localFileName, boolean isAscii) throws FtpServiceException {
		getFile(new String[]{remoteDir}, new String[]{remoteFileName}, new String[]{localFileName}, isAscii);
	}
	
	public void getFile(String remoteDir[], String[] remoteFileName, String[] localFileName ) throws FtpServiceException {
		getFile(remoteDir, remoteFileName, localFileName, false);
	}
	
	public void getFile(String remoteDir[], String[] remoteFileName, String[] localFileName, boolean isAscii ) throws FtpServiceException {
		if (remoteFileName.length != localFileName.length){
			throw new FtpServiceException("RemoteFileName[] Length not equal localFileName[] length"); 
		}
		
		ftpGetFile(remoteDir, remoteFileName, localFileName, isAscii, this.active);
	}
	
	public void ftpGetFile(String remoteDir[], String[] remoteFileName, String[] localFileName, boolean isAscii, boolean isActive) throws FtpServiceException {
		try{
			int length = remoteFileName.length;
			if (length == 0){
				return;
			}
			
			if (isActive){
				ftpClient.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.ACTIVE);
			}else{
				ftpClient.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.PASV);
			}
			
			if (listener != null){
				ftpClient.setEventListener(listener);
				ftpClient.getAdvancedSettings().setTransferNotifyInterval(1000000);
				listener.setJobSize(length);
			}
			
			ftpClient.connect();
			if (isAscii){
				ftpClient.setContentType(FTPTransferType.ASCII);
			}else{
				ftpClient.setContentType(FTPTransferType.BINARY);
			}
			
			String homeDir = ftpClient.getRemoteDirectory();
			
			for (int i = 0; i < length; i++){
				if (remoteDir[i] != null){
					ftpClient.changeDirectory(remoteDir[i]);
				}else{
					ftpClient.changeDirectory(homeDir);
				}
				
				long size = ftpClient.getSize(remoteFileName[i]);
				if (listener != null){
					listener.setJobIndex(i);
					listener.setFileSize(size);
				}	
				
				ftpClient.downloadFile(localFileName[i], remoteFileName[i]);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
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

	public void sendFile(String remoteDir, String remoteFileName, String localFileName) throws FtpServiceException {
		sendFile(new String[]{remoteDir}, new String[]{remoteFileName}, new String[]{localFileName}, false);		
	}
	
	public void sendFile(String remoteDir, String remoteFileName, String localFileName, boolean isAscii) throws FtpServiceException {
		sendFile(new String[]{remoteDir}, new String[]{remoteFileName}, new String[]{localFileName}, isAscii);		
	}
	
	public void sendFile(String[] remoteDir, String[] remoteFileName, String[] localFileName) throws FtpServiceException {
		sendFile(remoteDir, remoteFileName, localFileName, false);
	}
	
	public void sendFile(String[] remoteDir, String[] remoteFileName, String[] localFileName,  boolean isAscii) throws FtpServiceException {
		if (remoteFileName.length != localFileName.length){
			throw new FtpServiceException("RemoteFileName[] Length not equal localFileName[] length"); 
		}
		
		ftpSendFile(remoteDir, remoteFileName, localFileName, isAscii, this.active);
	}

	public void ftpSendFile(String[] remoteDir, String[] remoteFileName, String[] localFileName, boolean isAscii, boolean isActive) throws FtpServiceException {
		try{
			int length = localFileName.length;
			if (length == 0){
				return;
			}
			
			if (isActive){
				ftpClient.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.ACTIVE);
			}else{
				ftpClient.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.PASV);
			}
			
			if (listener != null){
				ftpClient.setEventListener(listener);
				ftpClient.getAdvancedSettings().setTransferNotifyInterval(1000000);
				listener.setJobSize(length);
			}
			
			ftpClient.connect();
			if (isAscii){
				ftpClient.setContentType(FTPTransferType.ASCII);
			}else{
				ftpClient.setContentType(FTPTransferType.BINARY);
			}
			
			String homeDir = ftpClient.getRemoteDirectory();
					
			for (int i = 0; i < length; i++){
				if (remoteDir[i] != null){
					ftpClient.changeDirectory(remoteDir[i]);
				}else{
					ftpClient.changeDirectory(homeDir);
				}
				
				long size = getLocalFileSize(localFileName[i]);
				if (listener != null){
					listener.setJobIndex(i);
					listener.setFileSize(size);
				}	
				
				ftpClient.uploadFile(localFileName[i], remoteFileName[i]);
			}
			
		}catch(Exception e){
			e.printStackTrace();
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
	
	private long getLocalFileSize(String filename) {
		File file = new File(filename);
		return file.length();
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
	
	public FtpEventListener getListener() {
		return listener;
	}

	public void setListener(FtpEventListener listener) {
		this.listener = listener;
	}

	public void setAsyncStatus(AsyncStatus status) {
		if (this.listener != null){
			this.listener.setAsyncStatus(status);
		}
	}

}
