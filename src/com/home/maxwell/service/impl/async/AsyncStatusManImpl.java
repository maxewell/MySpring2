package com.home.maxwell.service.impl.async;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.dao.AsyncStatusDao;
import com.home.maxwell.domain.TxStatus;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.AsyncStatusListener;
import com.home.maxwell.service.AsyncStatusMan;

public class AsyncStatusManImpl implements AsyncStatusMan, AsyncStatusListener{
	protected static Logger logger = LoggerFactory.getLogger(AsyncStatusManImpl.class);
	
	protected List<AsyncStatus> statusList = Collections.synchronizedList(new ArrayList<AsyncStatus>());
	protected AsyncStatusDao asyncStatusDao;

	public void statusChanged(AsyncStatus status) {
		if (status.getStatus() == ConstantKey.ASYNC_STATUS_ENQ){
			this.asyncStatusDao.insert(status);
		}else{
			this.asyncStatusDao.update(status);
		}	
	}

	public void addAsyncStatus(AsyncStatus status) {
		this.statusList.add(status);
	}

	public AsyncStatusDao getAsyncStatusDao() {
		return asyncStatusDao;
	}

	public void setAsyncStatusDao(AsyncStatusDao asyncStatusDao) {
		this.asyncStatusDao = asyncStatusDao;
	}

	public List<TxStatus> queryTxStatusList(String userId, String txName) {
		return this.asyncStatusDao.queryTxStatusList(userId, txName);
	}

}
