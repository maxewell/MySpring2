package com.home.maxwell.service.impl.schedule;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ScheduleServiceNew;
import com.home.maxwell.service.ScheduleStatus;
import com.home.maxwell.service.ScheduleStatusListener;
import com.home.maxwell.service.ScheduleStatusMan;
import com.home.maxwell.service.TxStatus;

public class ScheduleServiceImpl implements ScheduleServiceNew{
	protected static String ORG_QUARTZ_JOB_CLASSNAME = "org.quartz.Job";
	protected static String QUARTZ_JOBBEAN_DATAMAP = "dataMap";
	protected static String QUARTZ_JOBBEAN_STATUS = "status";
		
	protected Scheduler scheduler;
	protected ScheduleStatusMan statusMan;

	public ScheduleStatus scheduleRun(String txName, Runnable r, Date date, String userId) throws SchedulerException {
		
		ScheduleStatus status = getTxScheduleStatus(txName, userId);
		
		JobDetail jobDetail = new JobDetail("jobdetail-" + txName, "group1", RunInvokingJobBean.class);
		jobDetail.getJobDataMap().put("runnable", r);
		jobDetail.getJobDataMap().put("status", status);
		
		Trigger trigger = new SimpleTrigger("trigger-" + txName, "group1", date);
		scheduler.scheduleJob(jobDetail, trigger);
		
		statusMan.addStatus(status);
		
		return status;
	}
	
	private ScheduleStatus getTxScheduleStatus(String txName, String userId) {
		ScheduleStatus status = new ScheduleStatusImpl();
		String txId = getTxId();
		status.setTxName(txName);
		status.setTxId(txId);
		status.setScheduleStatusListener((ScheduleStatusListener)this.statusMan);
		
		return status;
	}

	private String getTxId() {
		return UUID.randomUUID().toString();
	}
	
	public ScheduleStatus scheduleRun(String txName, String clsName, Date date, String userId, Map<String, Object> map) throws Exception {
		Class cls = validateJobInterface(clsName);
		if (cls == null){
			throw new Exception("Not implments Quartz Job Interface");
		}
		
		ScheduleStatus status = getTxScheduleStatus(txName, userId);
		
		JobDetail jobDetail = new JobDetail("jobdetail-" + txName, "group1", cls);
		jobDetail.getJobDataMap().put(QUARTZ_JOBBEAN_DATAMAP, map);
		jobDetail.getJobDataMap().put(QUARTZ_JOBBEAN_STATUS, status);
		
		Trigger trigger = new SimpleTrigger("trigger-" + txName, "group1", date);
		scheduler.scheduleJob(jobDetail, trigger);
		
		statusMan.addStatus(status);
		
		return status;
	}

	private Class validateJobInterface(String clsName) throws ClassNotFoundException {
		Class cls = Class.forName(clsName);
		Class[] classes = cls.getInterfaces();
		for (Class aclass : classes){
			if (ORG_QUARTZ_JOB_CLASSNAME.equals(aclass.getName())){
				return cls;
			}
		}
		
		return null;
	}

	public List<TxStatus> queryTxStatusList(String userId, String txName) {
		// TODO Auto-generated method stub
		return null;
	}

	public TxStatus queryTxStatus(String userId, String name, String statusId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	/* --------------------------------------- RunInvokingJob --------------------------------- */
	public static class RunInvokingJobBean extends BaseQuartzJobBean{
		protected Runnable runnable;
		
		@Override
		public void doSchedule(JobExecutionContext context)	throws JobExecutionException {
			runnable.run();
		}
		
		public void setRunnable(Runnable able){
			this.runnable = able;
		}



		
	}
	
}
