package com.home.maxwell.service.impl.async;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.home.maxwell.dao.AsyncStatusDao;
import com.home.maxwell.domain.TxStatusImpl;
import com.home.maxwell.domain.UserInfo;
import com.home.maxwell.helper.ThreadLocalHelper;
import com.home.maxwell.service.AsyncService;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.AsyncStatusListener;
import com.home.maxwell.service.AsyncStatusMan;
import com.home.maxwell.service.ITxCallable;
import com.home.maxwell.service.TxStatus;
import com.home.maxwell.service.impl.async.AbstractRunnableImpl;
import com.home.maxwell.service.impl.async.BlockPriorityQueue;

public class AsyncServiceImpl extends Thread implements AsyncService{
	//use the priority 
	protected BlockPriorityQueue<Callable<Boolean>> bpQueue;
	
	//How to monitor the status in the statusList and update the status to DB
	//protected List<AsyncStatus> statusList;
	protected AsyncStatusMan asyncStatusMan;

	//use to start thread to run;
	protected ExecutorService threadPoolService;
	
	public AsyncServiceImpl(){
		//statusList must be Thread-Safe
		//statusList = Collections.synchronizedList(new ArrayList<AsyncStatus>());
				
		threadPoolService = Executors.newFixedThreadPool(5);
	}
	
	public AsyncStatus asyncRun(String txname, final Runnable r, String userId) {
		//new一個ITxCallable的Anonymous物件instance,將Runable的run()包起來
		ITxCallable able = new AbstractRunnableImpl(){
			public void doAsync(){
				r.run();
			}
		};
		able.setName(txname);
		/*
		AsyncStatusDao dao = (AsyncStatusDao)ThreadLocalHelper.getBean("asyncStatusDao");
		able.setAsyncStatusDao(dao);
		*/
		
		AsyncStatus status = getTxAsyncStatus(able, txname, userId);
		//this.statusList.add(status);
		this.asyncStatusMan.addAsyncStatus(status);
		
		bpQueue.push(able);
		able.setEnQTime(System.currentTimeMillis());
		
		return status;
	}

	public AsyncStatus asyncRun(String txname, ITxCallable r, String userId) {
		
		r.setName(txname);
		
		AsyncStatus status = getTxAsyncStatus(r, txname, userId);
		//this.statusList.add(status);
		this.asyncStatusMan.addAsyncStatus(status);
		
		bpQueue.push(r);
		r.setEnQTime(System.currentTimeMillis());
		
		return status;
	}

	private AsyncStatus getTxAsyncStatus(ITxCallable able, String txname, String userId){
		AsyncStatus status = new AsyncStatusImpl();
		
		String txId = getTxId();
		status.setTxId(txId);
		status.setTxName(txname);
		status.setUserId(userId);
		status.setAsyncStatusListener((AsyncStatusListener)this.asyncStatusMan);
		
		able.setAsyncStatus(status);
		
		return status;
	}
	
	private String getTxId() {
		return UUID.randomUUID().toString();
	}

	public void run() {
		while (!isInterrupted()) {
			
			ITxCallable able;
			try {
				able = (ITxCallable)bpQueue.pop();
				able.setDeQTime(System.currentTimeMillis());
				Future<Boolean> future = this.submit(able);
				AsyncStatusImpl status = (AsyncStatusImpl)able.getAsyncStatus();
				status.setFuture(future);
				
				//是否在此,否則AsyncService過後無能力
				//this.statusList.remove(status);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	private Future<Boolean> submit(ITxCallable able) {
		return threadPoolService.submit(able);
	}

	public AsyncStatus queryTxProgress(AsyncStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TxStatus> queryTxStatusList(String userid, String txname) {
		return this.asyncStatusMan.queryTxStatusList(userid, txname);
	}
	
	public TxStatus queryTxStatus(String userId, String txname, String statusId) {
		return this.asyncStatusMan.queryTxStatus(userId, txname, statusId);
	}
	
	public BlockPriorityQueue<Callable<Boolean>> getBpQueue() {
		return bpQueue;
	}

	public void setBpQueue(BlockPriorityQueue<Callable<Boolean>> bpQueue) {
		this.bpQueue = bpQueue;
	}
	
	public AsyncStatusMan getAsyncStatusMan() {
		return asyncStatusMan;
	}

	public void setAsyncStatusMan(AsyncStatusMan asyncStatusMan) {
		this.asyncStatusMan = asyncStatusMan;
	}

	
}
