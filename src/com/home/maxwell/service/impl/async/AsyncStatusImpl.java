package com.home.maxwell.service.impl.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.service.AsyncStatus;

public class AsyncStatusImpl implements AsyncStatus{
	protected String txId;
	protected String name;
	protected String userId;
	protected long startTime;
	protected long endTime;
	protected int status = ConstantKey.ASYNC_STATUS_NEW;      //0:init, 1:EnQueue 2:DeQueue
	protected Future<Boolean> future;       //virtual property: result-> result: 0:Running, 1:Sucess, -1:Fail, 99: wait to run 
	protected int progress;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public String getTxId(){
		return this.txId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public int getResult(long timeout) throws InterruptedException, ExecutionException{
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
	public int getResult() throws Exception {
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
	public int waitResult() throws Exception {
		if (this.future == null) {
			return 99;
		}
		
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
