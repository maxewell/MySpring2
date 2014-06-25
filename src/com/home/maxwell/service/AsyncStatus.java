package com.home.maxwell.service;

import java.util.concurrent.ExecutionException;

public interface AsyncStatus {

	public void setTxId(String txId);
	public String getTxId();
	public void setName(String name);
	public String getName();
	public void setUserId(String id);
	public String getUserId();
	public void setStartTime(long start);
	public long getStartTime();
	public void setEndTime(long endtime);
	public long getEndTime();
	public void setStatus(int status);
	public int getStatus();
	public boolean isDone();
	public int getResult(long timeout) throws Exception;
	public int getResult() throws Exception;
	public int waitResult() throws Exception;
	public void setProgress(int val);
	public int getProgress();
}
