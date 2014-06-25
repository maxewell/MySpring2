package com.home.maxwell.service;


import java.util.List;

import com.home.maxwell.domain.UserInfo;

public interface AsyncService {
	public AsyncStatus asyncRun(String txname, Runnable r, String userId);
	public AsyncStatus asyncRun(String txname, ITxCallable r, String userId);
	public AsyncStatus queryTxProgress(AsyncStatus status);
	public List<AsyncStatus> queryAsyncTxStatusList(String userId, String txname);
}
