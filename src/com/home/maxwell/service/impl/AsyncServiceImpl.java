package com.home.maxwell.service.impl;

import com.home.maxwell.service.AsyncService;

public class AsyncServiceImpl implements AsyncService{

	public void asyncRun(Runnable r) {
		new Thread(r).start();
	}

}
