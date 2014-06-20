package com.home.maxwell.service.impl.async;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.home.maxwell.exception.FtpServiceException;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ITxCallable;

public abstract class AbstractRunnableImpl implements ITxCallable{
	protected static Logger logger = LoggerFactory.getLogger(AbstractRunnableImpl.class);
	protected int priority;
	protected String name;
	protected AsyncStatus status;

	protected Map<String, Object> dataMap;

	protected Date deQTime;
	protected Date enQTime;
	
	public Boolean call(){
		try {
			this.updateTxAsyncStatus("Running");
			doAsync();
			this.updateTxAsyncStatus("True");
		}catch(Throwable e){
			//TODO: LOG Exception
		
			this.updateTxAsyncStatus("False");
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
	
	public abstract void doAsync() throws Throwable;

	protected void updateTxAsyncStatus(String state){
		if (logger.isInfoEnabled()){
			logger.info("Update Async state: " + state);
		}
	}
	
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
