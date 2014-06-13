package com.home.maxwell.service;

public interface AsyncService {
	public AsyncStatus asyncRun(Runnable r);
}
