package com.home.maxwell.service.impl.async;

import com.home.maxwell.domain.TxStatusImpl;
import com.home.maxwell.service.ScheduleStatus;
import com.home.maxwell.service.ScheduleStatusListener;

public class ScheduleStatusImpl extends TxStatusImpl implements ScheduleStatus{
	protected ScheduleStatusListener listener;
	
	public void setScheduleStatusListener(ScheduleStatusListener listener) {
		this.listener = listener;
	}

}
