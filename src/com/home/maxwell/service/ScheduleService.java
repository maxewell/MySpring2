package com.home.maxwell.service;

import java.util.Date;
import java.util.Map;

public interface ScheduleService {
	public void scheduleService(String methodName, Map<String, Object> map, Date date) throws Exception;

	public void timeTaskService(Date date, Runnable runnable);
}
