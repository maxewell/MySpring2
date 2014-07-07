package com.home.maxwell.service.impl.schedule;

import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.service.ScheduleStatus;

public abstract class BaseQuartzJobBean extends QuartzJobBean{
	protected static Logger logger = LoggerFactory.getLogger(BaseQuartzJobBean.class);
	
	protected Map<String, Object> dataMap;
	protected ScheduleStatus status;

	@Override
	protected void executeInternal(JobExecutionContext context)throws JobExecutionException {
		try {
			this.updateTxScheduleDeQueue();
			preExecute(context);
			
			this.updateTxScheduleStatusStart();
			
			doSchedule(context);
			this.updateTxScheduleStatusSuccess();
		}catch(Throwable e){
			e.printStackTrace();
			this.updateTxScheduleStatusFail(e.getMessage());
		}
	}
	
	private void updateTxScheduleDeQueue() {
		updateTxScheduleStatus("DeQueue");
		this.status.setStatus(ConstantKey.ASYNC_STATUS_DEQ);
		
		status.refreshStatus();
	}

	private void updateTxScheduleStatusFail(String message) {
		updateTxScheduleStatus("Failed");
		this.status.setEndTime(System.currentTimeMillis());
		this.status.setStatus(ConstantKey.ASYNC_STATUS_DONE);
		this.status.setProgress(-1);
		this.status.setMessage(message);
		this.status.setResult(-1);
		
		//asyncStatusDao.update(this.status);
		status.refreshStatus();
	}

	private void updateTxScheduleStatusSuccess() {
		updateTxScheduleStatus("Successed");
		this.status.setEndTime(System.currentTimeMillis());
		this.status.setStatus(ConstantKey.ASYNC_STATUS_DONE);
		this.status.setProgress(100);
		this.status.setMessage("OK");
		this.status.setResult(1);
		
		//asyncStatusDao.update(this.status);
		status.refreshStatus();
	}

	private void updateTxScheduleStatusStart() {
		updateTxScheduleStatus("Running");
		this.status.setStartTime(System.currentTimeMillis());
		this.status.setStatus(ConstantKey.ASYNC_STATUS_START);
		
		//asyncStatusDao.update(this.status);
		status.refreshStatus();
	}

	private void updateTxScheduleStatus(String state) {
		if (logger.isInfoEnabled()){
			logger.info("Update Schedule state: " + state);
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
	
	public ScheduleStatus getStatus() {
		return status;
	}

	public void setStatus(ScheduleStatus status) {
		this.status = status;
	}
}
