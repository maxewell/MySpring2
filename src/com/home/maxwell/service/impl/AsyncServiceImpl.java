package com.home.maxwell.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.home.maxwell.domain.UserInfo;
import com.home.maxwell.service.AsyncService;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.ITxRunnable;
import com.home.maxwell.service.impl.async.AbstractRunnableImpl;
import com.home.maxwell.service.impl.async.BlockPriorityQueue;

public class AsyncServiceImpl extends Thread implements AsyncService{
	protected BlockPriorityQueue<Runnable> bpQueue;
	
	public AsyncStatus asyncRun(String name, final Runnable r) {
		ITxRunnable able = new AbstractRunnableImpl(){
			public void run(){
				r.run();
			}
		};
		able.setName(name);
		
		bpQueue.push(able);
		
		return null;
	}

	public AsyncStatus asyncRun(String name, ITxRunnable r) {
		// TODO Auto-generated method stub
		r.setName(name);
		bpQueue.push(r);
		
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

	private void submit(ITxRunnable able) {
		// TODO Auto-generated method stub
		
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
