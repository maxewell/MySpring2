package com.home.maxwell.service.impl.async;

import java.util.Date;
import java.util.List;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.MethodInvoker;

import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ScheduleServiceNew;
import com.home.maxwell.service.TxStatus;
import com.home.maxwell.service.impl.BaseQuartzScheduleServiceImpl.MethodInvokingJob;

public class ScheduleServiceImpl implements ScheduleServiceNew{
	protected Scheduler scheduler;


	public AsyncStatus scheduleRun(String txName, Runnable r, Date date, String userId) throws SchedulerException {
		
		JobDetail jobDetail = new JobDetail("jobdetail-" + txName, "group1", RunInvokingJob.class);
		jobDetail.getJobDataMap().put("runnable", r);
		
		Trigger trigger = new SimpleTrigger("trigger-" + txName, "group1", date);
		scheduler.scheduleJob(jobDetail, trigger);
		
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
	public static class RunInvokingJob extends QuartzJobBean{
		protected Runnable runnable;
		
		protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
			try {
				runnable.run();
			}catch(Throwable e){
				e.printStackTrace();
			}
		}
		
		public void setRunnable(Runnable able){
			this.runnable = able;
		}
	}
	
}
