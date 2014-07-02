package com.home.maxwell.service.impl.async;

import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public abstract class BaseQuartzJobBean extends QuartzJobBean{
	protected Map<String, Object> dataMap;

	@Override
	protected void executeInternal(JobExecutionContext context)throws JobExecutionException {
		
		try {
			preExecute(context);
			doSchedule(context);
		}catch(Throwable e){
			e.printStackTrace();
		}
	}
	
	protected void preExecute(JobExecutionContext context)throws JobExecutionException{
	}
	
	public abstract void doSchedule(JobExecutionContext context)throws JobExecutionException ;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}
