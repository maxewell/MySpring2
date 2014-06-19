package com.home.maxwell.service.impl.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.home.maxwell.service.AsyncStatus;

public class AsyncStatusImpl implements AsyncStatus{
	protected String txId;
	protected String name;
	protected Future<Boolean> future;

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public Future<Boolean> getFuture() {
		return future;
	}

	public void setFuture(Future<Boolean> future) {
		this.future = future;
	}
	
	public boolean isDone(){
		boolean rs = false;
		if (this.future != null){
			rs = this.future.isDone();
		}
		
		return rs;
	}
	
	public int getResult() throws InterruptedException, ExecutionException{
		if (!isDone()){
			return 0;
		}else if (this.future.get() == Boolean.TRUE){
			return 1;
		}else {
			return -1;
		}
				
	}
}
