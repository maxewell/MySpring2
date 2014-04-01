package com.home.maxwell.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.home.maxwell.service.ScheduleService;

public class TimeTaskServiceImpl implements ScheduleService{

	public void timeTaskService(Date date, final Runnable runnable) {
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				runnable.run();
			}
			
		}, date);
	}

	public void scheduleService(String methodName, Map<String, Object> map,
			Date date) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
