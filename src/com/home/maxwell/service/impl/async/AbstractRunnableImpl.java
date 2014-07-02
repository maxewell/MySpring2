package com.home.maxwell.service.impl.async;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.home.maxwell.ConstantKey;
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
	
	//一個要執行的作業,是否應該還要負責status的DB寫入?不是Async服務嗎?服務要像樣的
	//statusDao放在此,有點突兀
	//protected AsyncStatusDao asyncStatusDao;

	public Boolean call(){
		try {
			this.updateTxAsyncStatusStart();
			doAsync();	
			this.updateTxAsyncStatusSuccess();
		}catch(Throwable e){
			logger.error(e.getMessage(), e);
		
			this.updateTxAsyncStatusFail(e.getMessage());
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
	
	private void updateTxAsyncStatusFail(String msg) {
		updateTxAsyncStatus("Failed");
		this.status.setEndTime(System.currentTimeMillis());
		this.status.setStatus(ConstantKey.ASYNC_STATUS_DONE);
		this.status.setProgress(-1);
		this.status.setMessage(msg);
		this.status.setResult(-1);
		
		//asyncStatusDao.update(this.status);
		status.refreshStatus();
	}

	private void updateTxAsyncStatusSuccess() {
		updateTxAsyncStatus("Successed");
		this.status.setEndTime(System.currentTimeMillis());
		this.status.setStatus(ConstantKey.ASYNC_STATUS_DONE);
		this.status.setProgress(100);
		this.status.setMessage("OK");
		this.status.setResult(1);
		
		//asyncStatusDao.update(this.status);
		status.refreshStatus();
	}

	private void updateTxAsyncStatusStart() {
		updateTxAsyncStatus("Running");
		this.status.setStartTime(System.currentTimeMillis());
		this.status.setStatus(ConstantKey.ASYNC_STATUS_START);
		
		//asyncStatusDao.update(this.status);
		status.refreshStatus();
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
		
		//this.asyncStatusDao.update(this.status);
		status.refreshStatus();
	}

	public void setEnQTime(long date) {
		this.enQTime = date;
		this.status.setStatus(ConstantKey.ASYNC_STATUS_ENQ);
		
		//this.asyncStatusDao.insert(this.status);
		status.refreshStatus();
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
	
	/*
	public AsyncStatusDao getAsyncStatusDao() {
		return asyncStatusDao;
	}

	public void setAsyncStatusDao(AsyncStatusDao asyncStatusDao) {
		this.asyncStatusDao = asyncStatusDao;
	}
	*/
}
