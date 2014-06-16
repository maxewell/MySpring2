package com.home.maxwell.service.impl.async;

import java.util.Date;
import java.util.Map;


import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ITxRunnable;

public abstract class AbstractRunnableImpl implements ITxRunnable{
	protected int priority;
	protected String name;
	protected AsyncStatus status;

	protected Map<String, Object> dataMap;

	protected Date deQTime;
	protected Date enQTime;
	
	
	public int compareTo(Object o) {
		AbstractRunnableImpl ano = (AbstractRunnableImpl)o;
		return this.priority - ano.getPriority();
	}

	public void setRunData(Map<String, Object> map) {
		this.dataMap = map;
	}

	public void setDeQTime(Date date) {
		this.deQTime = date;
	}

	public void setEnQTime(Date date) {
		this.enQTime = date;
	}
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AsyncStatus getAsyncStatus() {
		return this.status;
	}

	public void setAsyncStatus(AsyncStatus status){
		this.status = status;
	}
}
