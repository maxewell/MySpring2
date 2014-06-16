package com.home.maxwell.service.impl.async;

import com.home.maxwell.service.AsyncStatus;

public class AsyncStatusImpl implements AsyncStatus{
	protected String txId;
	protected String name;
	
	public void setTxId(String txId) {
		this.txId = txId;
	}

	public void setName(String name){
		this.name = name;
	}
}
