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
		String remoteDir = ServletRequestUtils.getRequiredStringParameter(request, "remoteDir");
		String remoteFile = ServletRequestUtils.getRequiredStringParameter(request, "remoteFile");
		String localFile = ServletRequestUtils.getRequiredStringParameter(request, "localFile");
		
		ftpService.sendFile(remoteDir, remoteFile, localFile, true);
		
		return new ModelAndView("ftpForm");
	}
	
	public ModelAndView onFtpGet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception, FtpServiceException {
		String remoteDir = ServletRequestUtils.getRequiredStringParameter(request, "remoteDir");
		String remoteFile = ServletRequestUtils.getRequiredStringParameter(request, "remoteFile");
		String localFile = ServletRequestUtils.getRequiredStringParameter(request, "localFile");
		
		ftpService.getFile(remoteDir, remoteFile, localFile, true);
		
		return new ModelAndView("ftpForm");
	}
	
	public FtpService getFtpService() {
		return ftpService;
	}

	public void setFtpService(FtpService ftpService) {
		this.ftpService = ftpService;
	}
}
