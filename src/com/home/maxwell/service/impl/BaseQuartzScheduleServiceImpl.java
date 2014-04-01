package com.home.maxwell.service.impl;

import java.util.Date;
import java.util.Map;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.MethodInvoker;

import com.home.maxwell.service.ScheduleService;

public class BaseQuartzScheduleServiceImpl implements ScheduleService{
	protected Scheduler scheduler;

	protected Map<String, JobDetail> jobDetailMap;
	protected JobDetail jobDetail;

	//wait to implement
	protected int count;
	
	public synchronized void scheduleService(String mock, Map<String, Object> map, Date date) throws Exception {
		String name = mock + String.valueOf(System.currentTimeMillis());
		System.out.println("name:" + name);
		this.jobDetail = new JobDetail("jobdetail-" + name, "group1", MethodInvokingJob.class);
		this.jobDetail.getJobDataMap().put("mockScheduleServiceImpl", this);
		this.jobDetail.getJobDataMap().put("run_Method", mock);
		this.jobDetail.getJobDataMap().put("run_Argument", map);
		this.jobDetail.setVolatility(true);
		this.jobDetail.setDurability(true);
		
		//scheduler.triggerJob(jobkey, jobdatamap);
		//name = "trigger-" + count++;
		Trigger trigger = new SimpleTrigger("trigger-" + name, "group1", date);
		
		scheduler.scheduleJob(this.jobDetail, trigger);
	}
	
	public Scheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
	public Map<String, JobDetail> getJobDetailMap() {
		return jobDetailMap;
	}

	public void setJobDetailMap(Map<String, JobDetail> jobDetailMap) {
		this.jobDetailMap = jobDetailMap;
	}

	public static class MethodInvokingJob extends QuartzJobBean {
		protected static final Logger logger = LoggerFactory.getLogger(MethodInvokingJob.class);

		private BaseQuartzScheduleServiceImpl impl;
		private String method;
		private Map<String, Object> map;

		public void setMockScheduleServiceImpl(BaseQuartzScheduleServiceImpl methodInvoker) {
			this.impl = methodInvoker;
		}

		public void setRun_Method(String method){
			this.method = method;
		}
		
		public void setRun_Argument(Map<String, Object> map){
			this.map = map;
		}

		protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
			MethodInvoker invoker= new MethodInvoker();
			invoker.setTargetObject(this.impl);
			invoker.setTargetMethod(this.method);
			invoker.setArguments(new Object[]{this.map});
			try {
				invoker.prepare();
				invoker.invoke();
				
			} catch (Exception e) {
				throw new JobExecutionException(e);
			}
		}
	}

	public void timeTaskService(Date date, Runnable runnable) {
		// TODO Auto-generated method stub
		
	}
}
