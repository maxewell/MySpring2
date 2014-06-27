package com.home.maxwell.service.impl.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.home.maxwell.domain.TxStatus;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.AsyncStatusListener;

public class AsyncStatusImpl extends TxStatus implements AsyncStatus{
	protected Future<Boolean> future;       //virtual property: result-> result: 0:Running, 1:Sucess, -1:Fail, 99: wait to run 
	protected AsyncStatusListener listener;
		
	public void refreshStatus() {
		if (listener != null){
			listener.statusChanged(this);
		}
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
	
	//result: 0:Running, 1:Sucess, -1:Fail, 99: wait to running
	public int getTxResult(long timeout) throws InterruptedException, ExecutionException{
		if (this.future == null) {
			return 99;
		}
		
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

	//result: 0:Running, 1:Sucess, -1:Fail, 99: wait to running
	public int getTxResult() throws Exception {
		if (this.future == null) {
			return 99;
		}
		
		if (!isDone()){
			return 0;
		}else if (this.future.get() == Boolean.TRUE){
			return 1;
		}else {
			return -1;
		}
	}

	//result: 0:Running, 1:Sucess, -1:Fail, 99: wait to running
	public int waitTxResult() throws Exception {
		if (this.future == null) {
			return 99;
		}
		
		if (this.future.get() == Boolean.TRUE){
			return 1;
		}else {
			return -1;
		}
		
	}

	public void setAsyncStatusListener(AsyncStatusListener listener) {
		this.listener = listener;
	}


	
}
