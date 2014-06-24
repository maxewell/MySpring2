package com.home.maxwell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.exception.FtpServiceException;
import com.home.maxwell.service.FtpService;

public class FtpController extends ApctlController{
	protected FtpService ftpService;

	public ModelAndView onFtpForm(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		return new ModelAndView("ftpForm");
	}
	
	public ModelAndView onFtpSend(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception, FtpServiceException {
		//String remoteDir = ServletRequestUtils.getRequiredStringParameter(request, "remoteDir");
		//String remoteFile = ServletRequestUtils.getRequiredStringParameter(request, "remoteFile");
		//String localFile = ServletRequestUtils.getRequiredStringParameter(request, "localFile");
		//ftpService.sendFile(remoteDir, remoteFile, localFile, true);
		
		String[] remoteDirs = new String[]{null, "daynet2bli"};
		String[] remoteFiles = new String[]{"FtpTestOK.zip", "20130401_POK.txt"};
		String[] localFiles = new String[]{"F:/FtpTestOK.zip", "F:/20130401_POK.txt"};
		ftpService.sendFile(remoteDirs, remoteFiles, localFiles);
		
		return new ModelAndView("ftpForm");
	}
	
	public ModelAndView onFtpGet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception, FtpServiceException {
		/*
		String remoteDir = ServletRequestUtils.getRequiredStringParameter(request, "remoteDir");
		String remoteFile = ServletRequestUtils.getRequiredStringParameter(request, "remoteFile");
		String localFile = ServletRequestUtils.getRequiredStringParameter(request, "localFile");
		remoteDir = null;
		remoteFile = "FtpTest.zip";
		localFile="F:/FtpTestOk.zip";
		ftpService.getFile(remoteDir, remoteFile, localFile, false);
		*/
		
		
		String[] remoteDirs = new String[]{null, "daynet2bli"};
		String[] remoteFiles = new String[]{"FtpTest.zip", "20130401_P.txt"};
		String[] localFiles = new String[]{"F:/FtpTestOK.zip", "F:/20130401_POK.txt"};
		ftpService.getFile(remoteDirs, remoteFiles, localFiles);
		
		
		return new ModelAndView("ftpForm");
	}
	
	public FtpService getFtpService() {
		return ftpService;
	}

	public void setFtpService(FtpService ftpService) {
		this.ftpService = ftpService;
	}
}
