package com.home.maxwell.service;

import java.util.concurrent.ExecutionException;

public interface AsyncStatus {

	public void setTxId(String txId);
	public void setName(String name);
	public boolean isDone();
	public int getResult() throws InterruptedException, ExecutionException;
}
