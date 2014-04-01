package com.home.maxwell.service.impl;

import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.service.MailService;

public class SpringMailServiceImpl implements MailService{
	protected JavaMailSender mailSender;

	public void sendMail(String[] receipts, String from, String subject, String mailText) throws MessagingException {
		sendSimpleMail(receipts, from, null, subject, mailText, false);
	}

	public void sendSimpleMail(String[] receipts, String from, String[] ccs, String subject, String mailText, boolean isHtml) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, ConstantKey.ENCODING_STR_ARRAY[ConstantKey.ENCODING_UTF8_INDEX]);
		
		helper.setFrom(from);
		helper.setTo(receipts);
		if (ccs != null){
			helper.setCc(ccs);
		}	
		helper.setSubject(subject);
		helper.setText(mailText, isHtml);
		
		mailSender.send(message);
	}
	
	public void sendMail(String[] receipts, String from, String subject, String mailText, String fileName) throws MessagingException{
		//String[] pathNodes = fileName.split(System.getProperty("file.separator"));
		String[] pathNodes = null;
		if (fileName.indexOf("/") > 0){
			pathNodes = fileName.split("/");
		}else if (fileName.indexOf("\\") > 0){
			pathNodes = fileName.split("\\\\");
		}else{
			pathNodes = new String[] {fileName};
		}
		
		String attachName = pathNodes[pathNodes.length-1];
		sendMultipartMail(receipts, from, null, subject, mailText, false, new FileSystemResource(fileName), attachName);
	}
	
	public void sendMail(String[] receipts, String from, String subject, String mailText, InputStream os, String attachName) throws MessagingException {
		sendMultipartMail(receipts, from, null, subject, mailText, false, new InputStreamResource(os), attachName);		
	}
	
	public void sendMultipartMail(String[] receipts, String from, String[] ccs, String subject, String mailText, boolean isHtml, InputStreamSource os, String attachName) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, ConstantKey.ENCODING_STR_ARRAY[ConstantKey.ENCODING_UTF8_INDEX]);
		
		helper.setFrom(from);
		helper.setTo(receipts);
		if (ccs != null){
			helper.setCc(ccs);
		}	
		helper.setSubject(subject);
		helper.setText(mailText, isHtml);
		helper.addAttachment(attachName, os);
		//message.addInline("myLogo", new ClassPathResource("img/mylogo.gif"));
		
		mailSender.send(message);
	}

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	

}
