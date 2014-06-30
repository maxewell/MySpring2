package com.home.maxwell.service;

import java.util.List;

import com.home.maxwell.domain.TxStatusImpl;

public interface AsyncStatusMan {
	public void addAsyncStatus(AsyncStatus status);
	public List<TxStatus> queryTxStatusList(String userid, String txname);
	public TxStatus queryTxStatus(String userId, String txname, String statusId);
}
