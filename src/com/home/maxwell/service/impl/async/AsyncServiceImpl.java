package com.home.maxwell.service.impl.async;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
	
	public AsyncStatus asyncRun(String name, final Runnable r) {
		ITxCallable able = new AbstractRunnableImpl(){
			public Boolean call(){
				try {
					this.updateTxAsyncStatus("Running");
					r.run();
					this.updateTxAsyncStatus("True");
				}catch(Exception e){
					//TODO: LOG Exception
				
					this.updateTxAsyncStatus("False");
					return Boolean.FALSE;
				}
				
				return Boolean.TRUE;
			}
		};
		able.setName(name);
		
		AsyncStatus status = getTxAsyncStatus(able, name);
		this.statusList.add(status);
		
		bpQueue.push(able);
		
		return status;
	}

	public AsyncStatus asyncRun(String name, ITxCallable r) {
		
		r.setName(name);
		
		AsyncStatus status = getTxAsyncStatus(r, name);
		this.statusList.add(status);
		
		bpQueue.push(r);
		
		return status;
	}

	private AsyncStatus getTxAsyncStatus(ITxCallable able, String name){
		AsyncStatus status = new AsyncStatusImpl();
		
		String txId = getTxId();
		status.setTxId(txId);
		status.setName(name);
		able.setAsyncStatus(status);
		
		return status;
	}
	
	private String getTxId() {
		//TODO: 
		return "TXID";
	}

	public void run() {
		while (!isInterrupted()) {
			
			ITxCallable able;
			try {
				able = (ITxCallable)bpQueue.pop();
				able.setDeQTime(new Date());
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

	public List<AsyncStatus> queryAsyncTxStatusList(UserInfo user, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
