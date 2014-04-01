package com.home.maxwell.service;

import java.io.InputStream;

import javax.mail.MessagingException;

public interface MailService {
	public void sendMail(String[] receipts, String from, String subject, String mailText) throws MessagingException;
	public void sendMail(String[] receipts, String from, String subject, String mailText, String fileName) throws MessagingException;
	public void sendMail(String[] receipts, String from, String subject, String mailText, InputStream os, String attachName) throws MessagingException;
}
