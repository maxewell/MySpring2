package com.home.maxwell.service;

import java.util.Date;

public interface ScheduleStatus extends TxStatus{
	void setScheduleStatusListener(ScheduleStatusListener listener);
	void setScheduleTime(Date date);
	void refreshStatus();
}
