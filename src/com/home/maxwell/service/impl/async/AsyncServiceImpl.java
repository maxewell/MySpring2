package com.home.maxwell.service.impl.async;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.home.maxwell.domain.UserInfo;
import com.home.maxwell.service.AsyncService;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ITxCallable;
import com.home.maxwell.service.impl.async.AbstractRunnableImpl;
import com.home.maxwell.service.impl.async.BlockPriorityQueue;

public class AsyncServiceImpl extends Thread implements AsyncService{
	protected BlockPriorityQueue<Callable<Boolean>> bpQueue;
	protected List<AsyncStatus> statusList;
	protected ExecutorService threadPoolService;
	
	public AsyncServiceImpl(){
		statusList = new ArrayList<AsyncStatus>();
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
		
		AsyncStatus status = getTxAsyncStatus(able, txname, userId);
		this.statusList.add(status);
		
		bpQueue.push(able);
		able.setEnQTime(System.currentTimeMillis());
		
		return status;
	}

	public AsyncStatus asyncRun(String txname, ITxCallable r, String userId) {
		
		r.setName(txname);
		
		AsyncStatus status = getTxAsyncStatus(r, txname, userId);
		this.statusList.add(status);
		
		bpQueue.push(r);
		r.setEnQTime(System.currentTimeMillis());
		
		return status;
	}

	private AsyncStatus getTxAsyncStatus(ITxCallable able, String txname, String userId){
		AsyncStatus status = new AsyncStatusImpl();
		
		String txId = getTxId();
		status.setTxId(txId);
		status.setName(txname);
		status.setUserId(userId);
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

	public List<AsyncStatus> queryAsyncTxStatusList(String user, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BlockPriorityQueue<Callable<Boolean>> getBpQueue() {
		return bpQueue;
	}

	public void setBpQueue(BlockPriorityQueue<Callable<Boolean>> bpQueue) {
		this.bpQueue = bpQueue;
	}
}
