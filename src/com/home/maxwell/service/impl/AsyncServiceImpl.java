package com.home.maxwell.service.impl;

import com.home.maxwell.service.AsyncService;
import com.home.maxwell.service.AsyncStatus;

public class AsyncServiceImpl implements AsyncService{

	public AsyncStatus asyncRun(Runnable r) {
		//new Thread(r).start();
		return null;
	}

}
