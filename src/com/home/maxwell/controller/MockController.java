package com.home.maxwell.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.home.maxwell.model.MockFacade;
import com.home.maxwell.service.AsyncService;
import com.home.maxwell.service.ScheduleService;


public class MockController  extends ApctlController{
	protected MockFacade mockFacade;
	
	protected ScheduleService scheduleService;
	protected AsyncService asyncService;
	protected ScheduleService timerService;
	
	public ModelAndView onSomMethod(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		final Integer empid = ServletRequestUtils.getRequiredIntParameter(request, "empId");
		String name = ServletRequestUtils.getRequiredStringParameter(request, "empId");
		
		String uno = (String)WebUtils.getSessionAttribute(request, "UNO");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("EMPID", empid);
		map.put("NAME", name);
		map.put("UNO", uno);
		
		//if sync
		mockFacade.doMockSomething(empid);
		
		//if async
		asyncService.asyncRun(new Runnable(){
			public void run(){
				mockFacade.doMockSomething(empid);
			}
		});
		
		//schedule
		//若這樣寫，當schedule設為100分鐘後，則empid等memory是否還在是個問題。
		//考慮Spring作法
		/*
		Date date = new Date();
		scheduleService.scheduleService(date, new RunService(){
			public void run(){
				mockFacade.doMockSomething(empid);
			}
		});
		*/
		
		return null;
	}

	public ModelAndView onAsyncRun(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(Thread.currentThread().getName());
		final int data = 100; 
		asyncService.asyncRun(new Runnable(){
			public void run() {
				//System.out.println("T:" + Thread.currentThread().getName());
				mockFacade.doMockSomething(data);
			}
		});
		
		return new ModelAndView("welcome"); 
	}
	
	public ModelAndView onScheduleRun(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String idn = ServletRequestUtils.getRequiredStringParameter(request, "IDN");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("WELCOME", idn);
		
		long time = System.currentTimeMillis();
		Date date = new Date(time + 10*1000);
		
		scheduleService.scheduleService("mock", map, date);
		
		return new ModelAndView("welcome");
		
	}
	
	public ModelAndView onTimeTaskRun(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		final String idn = ServletRequestUtils.getRequiredStringParameter(request, "IDN");
		
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("WELCOME", idn);
		
		long time = System.currentTimeMillis();
		Date date = new Date(time + 10*1000);
		
		//final int data = 1000; 
		
		timerService.timeTaskService(date, new Runnable(){
			public void run() {
				mockFacade.doMockNothing(idn);
			}
			
		});
		
		return new ModelAndView("welcome");
		
	}

	public MockFacade getMockFacade() {
		return mockFacade;
	}

	public void setMockFacade(MockFacade mockFacade) {
		this.mockFacade = mockFacade;
	}
	
	public ScheduleService getScheduleService() {
		return scheduleService;
	}

	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	
	public AsyncService getAsyncService() {
		return asyncService;
	}

	public void setAsyncService(AsyncService asyncService) {
		this.asyncService = asyncService;
	}
	
	public ScheduleService getTimerService() {
		return timerService;
	}

	public void setTimerService(ScheduleService timerService) {
		this.timerService = timerService;
	}
}
