package com.home.maxwell.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.domain.Person;

public class ExceptionController extends ApctlController{

	public ModelAndView onShow(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Person person = new Person();
		person.setEmail("MaxMail@gmail.com");
		
		BindException bex = new BindException(person, "command");
		
		ObjectError err = new ObjectError("command", new String[]{"country.Error"}, null, "DefaultMessage");
		bex.addError(err);
		
		//bex.rejectValue("idn", "country.Error", null, "ErrorMsg");
		
		Map<String, Object> mapbex = bex.getModel();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.putAll(mapbex);
		map.put("MYKEY", "This is Value of MYKEY");
		

		return new ModelAndView("ExceptionDemo", map);
	}
}
