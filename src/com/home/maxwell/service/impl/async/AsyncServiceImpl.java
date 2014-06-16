package com.home.maxwell.service.impl.async;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.home.maxwell.domain.UserInfo;
import com.home.maxwell.service.AsyncService;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ITxRunnable;
import com.home.maxwell.service.impl.async.AbstractRunnableImpl;
import com.home.maxwell.service.impl.async.BlockPriorityQueue;

public class AsyncServiceImpl extends Thread implements AsyncService{
	protected BlockPriorityQueue<Runnable> bpQueue;
	protected List<AsyncStatus> statusList;
	protected ExecutorService threadPoolService;
	
	public AsyncServiceImpl(){
		statusList = new ArrayList<AsyncStatus>();
		threadPoolService = Executors.newFixedThreadPool(5);
	}
	
	public AsyncStatus asyncRun(String name, final Runnable r) {
		ITxRunnable able = new AbstractRunnableImpl(){
			public void run(){
				r.run();
			}
		};
		able.setName(name);
		
		AsyncStatus status = getTxAsyncStatus(able, name);
		this.statusList.add(status);
		
		bpQueue.push(able);
		
		return status;
	}

	public AsyncStatus asyncRun(String name, ITxRunnable r) {
		
		r.setName(name);
		
		AsyncStatus status = getTxAsyncStatus(r, name);
		this.statusList.add(status);
		
		bpQueue.push(r);
		
		return status;
	}

	private AsyncStatus getTxAsyncStatus(ITxRunnable able, String name){
		AsyncStatus status = new AsyncStatusImpl();
		
		String txId = getTxId();
		status.setTxId(txId);
		status.setName(name);
		able.setAsyncStatus(status);
		
		return status;
	}
	
	private String getTxId() {
		//TODO: 
		return null;
	}

	public void run() {
		while (!isInterrupted()) {
			
			ITxRunnable able;
			try {
				able = (ITxRunnable)bpQueue.pop();
				able.setDeQTime(new Date());
				this.submit(able);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	private Future submit(ITxRunnable able) {
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
