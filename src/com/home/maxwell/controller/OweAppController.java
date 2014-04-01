package com.home.maxwell.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;

import com.home.maxwell.domain.OweApp;
import com.home.maxwell.domain.OweCal;
import com.home.maxwell.exception.ApctlErrCodeEnum;
import com.home.maxwell.exception.ApctlException;
import com.home.maxwell.form.OweCalForm;
import com.home.maxwell.model.OweFacade;

public class OweAppController extends ApctlController{
	protected static Logger logger = LoggerFactory.getLogger("OweAppController");
	
	protected String SEESION_ATTR_OWECAL_LIST = "___OWE__CAL_LIST";
	protected String calYmView;
	protected String calInputView;
	protected OweFacade oweFacade;

	public ModelAndView onShow(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		OweApp oweapp = new OweApp();
		
		ModelAndView mv = new ModelAndView(this.calYmView, "command", oweapp);
		return mv;
	}
	
	//OweApp only valiate the oweYm
	public ModelAndView onQueryCalList(HttpServletRequest request, HttpServletResponse response, HttpSession session, OweApp app){
		
		if (session == null){
			session = request.getSession();
		}
		session.setAttribute("OWE_APP", app);
	
		OweCalForm form = new OweCalForm();
			
		session.setAttribute("OWE_CAL_FORM", form);
		form.setOweYm(app.getOweYm());
		//form.setOweApp(app);
		
		//模擬處理時發生Exception時，要回到前一頁並回應處理錯誤
		/*
		try {
			int main = 10;
			int div = 0;
			main = main / div;
		}catch(Throwable t) {
			return throwResponse(request, this.calYmView, "command", app);
		}
		*/
		
		ModelAndView mv = new ModelAndView(this.calInputView, "command", form);
		return mv;
	}

	//OweCalForm validate oweYm & idn of OweCal
	public ModelAndView onQueryOweData(HttpServletRequest request, HttpServletResponse response, HttpSession session, OweCalForm form) throws ServletRequestBindingException{
		
		List<OweCal> owecallist = form.getOweCalList();
		for (OweCal cal : owecallist){
			logger.info("IDN:" + cal.getIdn() + ":" + cal.getBrdate());
		}
		
		//模擬處理時發生Exception時，要回到前一頁並回應處理錯誤
		
		try {
			int main = 10;
			int div = 0;
			main = main / div;
		}catch(Throwable t) {
			List<String> params = new ArrayList<String>();
			params.add("ME");
			params.add("CPA");
			throw new ApctlException(this.calInputView, ApctlErrCodeEnum.ERROR_5_00_1_001, params, "command", form);
			//return throwResponse(request, this.calYmView, "command", form);
		}
		
		ModelAndView mv = new ModelAndView(this.calInputView, "command", form);
		return mv;
	}
		
	public String getCalYmView() {
		return calYmView;
	}

	public void setCalYmView(String calYmView) {
		this.calYmView = calYmView;
	}

	public String getCalInputView() {
		return calInputView;
	}

	public void setCalInputView(String calInputView) {
		this.calInputView = calInputView;
	}
	
	public OweFacade getOweFacade() {
		return oweFacade;
	}

	public void setOweFacade(OweFacade oweFacade) {
		this.oweFacade = oweFacade;
	}
}
