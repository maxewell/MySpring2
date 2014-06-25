package com.home.maxwell.service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;

public interface ITxCallable extends Callable<Boolean>, Comparable{
	void setAsyncStatus(AsyncStatus status);
	AsyncStatus getAsyncStatus();
	//void setITxPriorityRunnableBook(ITxPriorityRunnableBook book);
	void setRunData(Map<String, Object> map);
	
	void setDeQTime(long date);
	long getDeQTime();
	void setEnQTime(long date);
	long getEnQTime();
	void setName(String name);
	
}
