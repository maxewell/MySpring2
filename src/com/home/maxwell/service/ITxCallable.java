package com.home.maxwell.service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;

import com.home.maxwell.dao.AsyncStatusDao;

public interface ITxCallable extends Callable<Boolean>, Comparable{
	void setRunData(Map<String, Object> map);
	
	void setDeQTime(long date);
	long getDeQTime();
	void setEnQTime(long date);
	long getEnQTime();
	void setName(String name);
	
	//輔助記錄用
	void setAsyncStatus(AsyncStatus status);
	AsyncStatus getAsyncStatus();
	AsyncStatusDao getAsyncStatusDao();
	void setAsyncStatusDao(AsyncStatusDao asyncStatusDao);
}
