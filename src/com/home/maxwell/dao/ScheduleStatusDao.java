package com.home.maxwell.dao;

import java.util.List;

import com.home.maxwell.service.ScheduleStatus;

public interface ScheduleStatusDao {
	void update(ScheduleStatus status);
	void insert(ScheduleStatus status);
	List<ScheduleStatus> queryTxStatusList(String userId, String txName);
	ScheduleStatus queryTxStatus(String userId, String txName, String statusId);
}
