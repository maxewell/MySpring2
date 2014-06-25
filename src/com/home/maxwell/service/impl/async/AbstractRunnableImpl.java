package com.home.maxwell.service.impl.async;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.home.maxwell.ConstantKey;
import com.home.maxwell.dao.AsyncStatusDao;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ITxCallable;

public abstract class AbstractRunnableImpl implements ITxCallable{
	protected static Logger logger = LoggerFactory.getLogger(AbstractRunnableImpl.class);
	protected int priority;
	protected String name;
	protected AsyncStatus status; 

	protected Map<String, Object> dataMap;

	protected long deQTime;
	protected long enQTime;
	
	protected AsyncStatusDao asyncStatusDao;
	
	public Boolean call(){
		try {
			this.updateTxAsyncStatusStart();
			doAsync();
			this.updateTxAsyncStatusSuccess();
		}catch(Throwable e){
			logger.error(e.getMessage(), e);
		
			this.updateTxAsyncStatusFail();
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
	
	private void updateTxAsyncStatusFail() {
		updateTxAsyncStatus("Successed");
		this.status.setEndTime(System.currentTimeMillis());
		this.status.setProgress(0);
		asyncStatusDao.update(this.status);
	}

	private void updateTxAsyncStatusSuccess() {
		updateTxAsyncStatus("Successed");
		this.status.setEndTime(System.currentTimeMillis());
		this.status.setProgress(100);
		asyncStatusDao.update(this.status);
	}

	private void updateTxAsyncStatusStart() {
		updateTxAsyncStatus("Running");
		this.status.setStartTime(System.currentTimeMillis());
		asyncStatusDao.update(this.status);
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

	public void setDeQTime(long date) {
		this.deQTime = date;
		this.status.setStatus(ConstantKey.ASYNC_STATUS_DEQ);
	}

	public void setEnQTime(long date) {
		this.enQTime = date;
		this.status.setStatus(ConstantKey.ASYNC_STATUS_ENQ);
		this.asyncStatusDao.insert(this.status);
		
	}
	public long getDeQTime() {
		return this.deQTime;
	}

	public long getEnQTime() {
		return this.enQTime;
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
