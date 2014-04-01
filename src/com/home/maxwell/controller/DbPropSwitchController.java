package com.home.maxwell.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.domain.Person;

public class DbPropSwitchController extends ApctlController{
	protected Person  person;

	public ModelAndView onShow(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		return new ModelAndView("dbProperty", "command", person);
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
