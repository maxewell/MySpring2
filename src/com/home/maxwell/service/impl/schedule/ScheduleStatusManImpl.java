package com.home.maxwell.service.impl.schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.dao.ScheduleStatusDao;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ScheduleStatus;
import com.home.maxwell.service.ScheduleStatusListener;
import com.home.maxwell.service.ScheduleStatusMan;

public class ScheduleStatusManImpl implements ScheduleStatusMan, ScheduleStatusListener{
	protected static final Logger logger = LoggerFactory.getLogger(ScheduleStatusManImpl.class);
	
	protected List<ScheduleStatus> statusList = Collections.synchronizedList(new ArrayList<ScheduleStatus>());
	protected ScheduleStatusDao scheduleStatusDao;

	public void addStatus(ScheduleStatus status) {
		statusList.add(status);
	}

	public void statusChanged(ScheduleStatus status) {
		if (status.getStatus() == ConstantKey.ASYNC_STATUS_ENQ){
			this.scheduleStatusDao.insert(status);
		}else{
			this.scheduleStatusDao.update(status);
		}	
	}

	
	public ScheduleStatusDao getScheduleStatusDao() {
		return scheduleStatusDao;
	}

	public void setScheduleStatusDao(ScheduleStatusDao scheduleStatusDao) {
		this.scheduleStatusDao = scheduleStatusDao;
	}
}
