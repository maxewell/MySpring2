package com.home.maxwell.service;

import java.util.Date;
import java.util.List;

import org.quartz.SchedulerException;

public interface ScheduleServiceNew {

	ScheduleStatus scheduleRun(String txName, Runnable r, Date date, String userId) throws SchedulerException;
	public List<TxStatus> queryTxStatusList(String userId, String txName);
	public TxStatus queryTxStatus(String userId, String name, String statusId);

}
