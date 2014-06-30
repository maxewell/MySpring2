package com.home.maxwell.service;

public interface TxStatus {
	public void setTxId(String txId);
	public String getTxId();
	public void setTxName(String name);
	public String getTxName();
	public void setUserId(String id);
	public String getUserId();
	public void setStartTime(long start);
	public long getStartTime();
	public void setEndTime(long endtime);
	public long getEndTime();
	public void setStatus(int status);
	public int getStatus();
	public void setProgress(int val);
	public int getProgress();
	public void setMessage(String msg);
	public String getMessage();
	public void setResult(int rs);
	public int getResult();
}
