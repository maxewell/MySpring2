package com.home.maxwell.service;

import com.home.maxwell.exception.FtpServiceException;

public interface FtpService {
	public void getFile(String remoteDir, String remoteFileName, String localFileName)throws FtpServiceException;
	public void getFile(String remoteDir, String remoteFileName, String localFileName, boolean isAscii)throws FtpServiceException;
	public void sendFile(String remoteDir, String remoteFileName, String localFileName)throws FtpServiceException;
	public void sendFile(String remoteDir, String remoteFileName, String localFileName, boolean isAscii)throws FtpServiceException;
	public void getFile(String remoteDir[], String[] remoteFileName, String[] localFileName)throws FtpServiceException;
	public void getFile(String remoteDir[], String[] remoteFileName, String[] localFileName, boolean isAscii)throws FtpServiceException;
	public void sendFile(String remoteDir[], String[] remoteFileName, String[] localFileName)throws FtpServiceException;
	public void sendFile(String remoteDir[], String[] remoteFileName, String[] localFileName, boolean isAscii)throws FtpServiceException;
}
