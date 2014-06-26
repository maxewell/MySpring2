package com.home.maxwell.service;

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
	public int getTxResult(long timeout) throws Exception;
	public int getTxResult() throws Exception;
	public int waitTxResult() throws Exception;
	public void setProgress(int val);
	public int getProgress();
	public void setMessage(String msg);
	public String getMessage();
	public void setResult(int rs);
	public int getResult();
}
