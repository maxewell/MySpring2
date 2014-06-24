package com.home.maxwell.service;

import java.util.concurrent.ExecutionException;

public interface AsyncStatus {

	public void setTxId(String txId);
	public void setName(String name);
	public boolean isDone();
	public int getResult(long timeout) throws Exception;
	public int getResult() throws Exception;
	public int waitResult() throws Exception;
	public void setProgress(int val);
	public int getProgress();
}
