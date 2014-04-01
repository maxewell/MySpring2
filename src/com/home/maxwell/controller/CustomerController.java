package com.home.maxwell.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.home.maxwell.domain.Person;

public class CustomerController extends ApctlController{
	protected Logger logger = LoggerFactory.getLogger(CustomerController.class);
	private Person person;

	public ModelAndView onAddCustomer(HttpServletRequest request,
		HttpServletResponse response, Person inperson) throws Exception {
		
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		
		//WebUtils.setWebAppRootSystemProperty(context);
		//String rootdir1 = System.getProperty("SpringSiteMesh");
		//person.usingFTP();
		
		session.setAttribute("custmsg", person.getFirstName() + ":" + person.getLastName() + 
				":" + person.getEmail() + ":" + person.getCar());
		
		return new ModelAndView("CustomerPage", "msg","add() method");
			
	}
	
	public long onAddCustomerLastModified(HttpServletRequest request) throws Exception {
		return -1;
	}
	
	public ModelAndView onDeleteCustomer(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
			
		return new ModelAndView("CustomerPage", "msg","delete() method");
				
	}
	
	public ModelAndView onUpdateCustomer(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
			
		return new ModelAndView("CustomerPage", "msg","update() method");
				
	}
	
	public ModelAndView onListCustomer(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
				
		return new ModelAndView("CustomerPage", "msg","list() method");
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public ModelAndView hanldeBindException(HttpServletRequest request, HttpServletResponse response, ServletRequestBindingException bindingException) {
		//logger.info(bindingException.getMessage(), bindingException.getRootCause());
				
		BindException be = (BindException)bindingException.getCause();
		BindingResult br = be.getBindingResult();
		
		logger.info("Validator Error count:" + be.getErrorCount());
		logger.info("getFieldErrorCount:" + be.getFieldErrorCount());
		List<FieldError> lsf = be.getFieldErrors();
		for (FieldError error : lsf){
			logger.info("Filed:" + error.getField() + ":" + error.getCode());
		}
		return null;
	}
}
