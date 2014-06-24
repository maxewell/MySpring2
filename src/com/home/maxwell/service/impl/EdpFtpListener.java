package com.home.maxwell.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.enterprisedt.net.ftp.EventListener;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.FtpEventListener;

public class EdpFtpListener implements FtpEventListener{
	protected static Logger logger = LoggerFactory.getLogger(EdpFtpListener.class);
	
	protected AsyncStatus status;
	protected int jobSize;
	protected int jobIndex;
	protected long[] jobFileSize;
	protected long fileSize;
	
	/**
	 * Log an FTP command being sent to the server. Not used for SFTP.
	 * 
	 * @param cmd
	 *            command string
	 */
	public void commandSent(String connId, String cmd) {
		logger.info("Command sent: " + cmd);
	}	
	
	/**
	 * Log an FTP reply being sent back to the client. Not used for SFTP.
	 * 
	 * @param reply
	 *            reply string
	 */
	public void replyReceived(String connId, String reply) {
		logger.info("Reply received: " + reply);
	}
	
	public void bytesTransferred(String connId, String remoteFilename,	long bytes) {
		logger.info(remoteFilename + " Bytes transferred=" + bytes);
		float val = (float) bytes/fileSize;
		int progress = (int) (val * 100);
		
		if ( (progress % 10) == 0 ) {
			//log.info(bytes + "|" + allSize + "|" + progress);
		}	
		
		if (status != null){
			status.setProgress(progress);
		}	
	}

	/**
	 * Notifies that a download has started
	 * 
	 * @param remoteFilename
	 *            remote file name
	 */
	public void downloadStarted(String connId, String remoteFilename) {
		logger.info("Started download: " + remoteFilename);
		if (status != null){
			status.setProgress(0);
		}
	}

	/**
	 * Notifies that a download has completed
	 * 
	 * @param remoteFilename
	 *            remote file name
	 */
	public void downloadCompleted(String connId, String remoteFilename) {
		logger.info("Completed download: " + remoteFilename);
		if (status != null){
			status.setProgress(100);
		}
	}
	
	/**
	 * Notifies that an upload has started
	 * 
	 * @param remoteFilename
	 *            remote file name
	 */
	public void uploadStarted(String connId, String remoteFilename) {
		logger.info("Started upload: " + remoteFilename);
		if (status != null){
			status.setProgress(0);
		}
	}

	/**
	 * Notifies that an upload has completed
	 * 
	 * @param remoteFilename
	 *            remote file name
	 */
	public void uploadCompleted(String connId, String remoteFilename) {
		logger.info("Completed upload: " + remoteFilename);
		if (status != null){
			status.setProgress(100);
		}
	}

	public void setStatus(AsyncStatus status){
		this.status = status;
	}

	public void setFileSize(long size) {
		this.fileSize = size;	
		this.jobFileSize[this.jobIndex] = size;
	}
	
	public int getJobSize() {
		return jobSize;
	}

	public void setJobSize(int jobSize) {
		this.jobSize = jobSize;
		this.jobFileSize= new long[jobSize];
	}

	public int getJobIndex() {
		return jobIndex;
	}

	public void setJobIndex(int jobIndex) {
		this.jobIndex = jobIndex;
	}

}
