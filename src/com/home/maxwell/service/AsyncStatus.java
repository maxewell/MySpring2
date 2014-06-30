package com.home.maxwell.service;

public interface AsyncStatus extends TxStatus{
	
	public boolean isDone();
	public int getTxResult(long timeout) throws Exception;
	public int getTxResult() throws Exception;
	public int waitTxResult() throws Exception;
	
	public void setAsyncStatusListener(AsyncStatusListener listener);
	public void refreshStatus();
}
