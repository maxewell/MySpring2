package com.home.maxwell.service;

import java.util.Date;
import java.util.Map;

public interface ITxRunnable extends Runnable, Comparable{
	//void setRunningId(String id);
	//void setITxPriorityRunnableBook(ITxPriorityRunnableBook book);
	void setRunData(Map<String, Object> map);
	
	void setDeQTime(Date date);
	void setEnQTime(Date date);
	
}
