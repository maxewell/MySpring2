package com.home.maxwell.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.domain.Person;
import com.home.maxwell.domain.Preferences;

public class FormDemoController extends ApctlController{
	protected String inputForm;
	protected String updateForm;

	public ModelAndView onShow(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Person person = new Person();
		person.setIdn("A123456789");
		Preferences preferences = new Preferences();
		preferences.setFavouriteWord("IBM");
		preferences.setInterests(new String[]{
				"Quidditch",
				//"Herbology", 
				"Defence Against the Dark Arts"});
		person.setPreferences(preferences);
		
		String[] interestList= new String[]{
				"Quidditch",
				"Herbology", 
				"Defence Against the Dark Arts"
		};
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("command", person);
		map.put("interestList", interestList);
		
		return new ModelAndView(inputForm, map);
		
	}
	
	public ModelAndView onUpdateRef(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Enumeration enums = request.getParameterNames();
		while(enums.hasMoreElements()){
			String param = (String)enums.nextElement();
			System.out.println(param);
			Object obj = request.getParameter(param);
			System.out.println(obj.toString());
		}
		String[] datas1 = request.getParameterValues("preferences.interests");
		String[] datas2 = request.getParameterValues("_preferences.interests");
		return new ModelAndView(updateForm);
	}
	
	public String getInputForm() {
		return inputForm;
	}

	public void setInputForm(String inputForm) {
		this.inputForm = inputForm;
	}
	
	public String getUpdateForm() {
		return updateForm;
	}

	public void setUpdateForm(String inputForm) {
		this.updateForm = inputForm;
	}
}
