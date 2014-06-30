package com.home.maxwell.dao;

import java.util.List;

import com.home.maxwell.domain.TxStatusImpl;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.TxStatus;

public interface AsyncStatusDao {
	void update(AsyncStatus status);
	void insert(AsyncStatus status);
	List<TxStatus> queryTxStatusList(String userId, String txName);
	TxStatus queryTxStatus(String userId, String txName, String statusId);

}
