package com.home.maxwell.service.impl.schedule;

import java.util.Date;

import com.home.maxwell.domain.TxStatusImpl;
import com.home.maxwell.service.ScheduleStatus;
import com.home.maxwell.service.ScheduleStatusListener;

public class ScheduleStatusImpl extends TxStatusImpl implements ScheduleStatus{
	protected Date scheduleTime;

	protected ScheduleStatusListener listener;
	
	public void setScheduleStatusListener(ScheduleStatusListener listener) {
		this.listener = listener;
	}

	public void refreshStatus() {
		if (listener != null){
			listener.statusChanged(this);
		}
	}

	public Date getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

}
