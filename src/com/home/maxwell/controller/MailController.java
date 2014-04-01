package com.home.maxwell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.service.MailService;

public class MailController extends ApctlController{
	protected MailService mailService;

	public ModelAndView onMailForm(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		return new ModelAndView("mailForm");
	}
	
	public ModelAndView onSendMail(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		String tos = ServletRequestUtils.getRequiredStringParameter(request, "tos");
		String from = ServletRequestUtils.getRequiredStringParameter(request, "from");
		String subject = ServletRequestUtils.getRequiredStringParameter(request, "subject");
		String mailtext = ServletRequestUtils.getRequiredStringParameter(request, "mailtext");
		String attach = ServletRequestUtils.getRequiredStringParameter(request, "attach");
		
		String[] receipts = tos.split(";");
		
		if (attach == null || attach.isEmpty()){
			mailService.sendMail(receipts, from, subject, mailtext);
		}else{
			mailService.sendMail(receipts, from, subject, mailtext, attach);
		}
		
		return new ModelAndView("mailForm");
	}
	
	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	
	
}
