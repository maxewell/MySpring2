package com.home.maxwell.service;

import java.util.List;

import com.home.maxwell.domain.TxStatus;

public interface AsyncStatusMan {
	public void addAsyncStatus(AsyncStatus status);
	public List<TxStatus> queryTxStatusList(String userid, String txname);
}
