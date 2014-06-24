package com.home.maxwell.service.impl.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.home.maxwell.service.AsyncStatus;

public class AsyncStatusImpl implements AsyncStatus{
	protected String txId;
	protected String name;
	protected Future<Boolean> future;
	protected int progress;

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
	
	public int getResult(long timeout) throws InterruptedException, ExecutionException{
		Boolean rs = null;
		try {
			rs = this.future.get(timeout, TimeUnit.MILLISECONDS);
		}catch (TimeoutException e){
			return 0;
		}
		
		if (rs == Boolean.TRUE){
			return 1;
		}else{
			return -1;
		}
		
	}

	public int getResult() throws Exception {
		if (!isDone()){
			return 0;
		}else if (this.future.get() == Boolean.TRUE){
			return 1;
		}else {
			return -1;
		}
	}

	public int waitResult() throws Exception {
		if (this.future.get() == Boolean.TRUE){
			return 1;
		}else {
			return -1;
		}
		
	}
	

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}
}
