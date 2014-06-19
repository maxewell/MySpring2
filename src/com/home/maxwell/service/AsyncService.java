package com.home.maxwell.service;


import java.util.List;

import com.home.maxwell.domain.UserInfo;

public interface AsyncService {
	public AsyncStatus asyncRun(String name, Runnable r);
	public AsyncStatus asyncRun(String name, ITxCallable r);
	public AsyncStatus queryTxProgress(AsyncStatus status);
	public List<AsyncStatus> queryAsyncTxStatusList(UserInfo user, String name);
}
