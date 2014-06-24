package com.home.maxwell.service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;

public interface ITxCallable extends Callable<Boolean>, Comparable{
	void setAsyncStatus(AsyncStatus status);
	AsyncStatus getAsyncStatus();
	//void setITxPriorityRunnableBook(ITxPriorityRunnableBook book);
	void setRunData(Map<String, Object> map);
	
	void setDeQTime(Date date);
	void setEnQTime(Date date);
	void setName(String name);
	
}
