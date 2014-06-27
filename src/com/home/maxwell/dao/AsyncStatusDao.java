package com.home.maxwell.dao;

import java.util.List;

import com.home.maxwell.domain.TxStatus;
import com.home.maxwell.service.AsyncStatus;

public interface AsyncStatusDao {
	void update(AsyncStatus status);
	void insert(AsyncStatus status);
	List<TxStatus> queryTxStatusList(String userId, String txName);

}
