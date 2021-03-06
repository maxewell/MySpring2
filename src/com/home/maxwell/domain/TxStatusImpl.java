package com.home.maxwell.domain;

import com.home.maxwell.ConstantKey;
import com.home.maxwell.service.TxStatus;

public class TxStatusImpl implements TxStatus{
	protected String txId;				//TxID
	protected String txName;				//Tx name
	protected String userId;			//呼叫執行Tx的人
	protected long startTime;			//
	protected long endTime;
	protected int status = ConstantKey.ASYNC_STATUS_NEW;      //0:init, 1:EnQueue, 2:DeQueue(submit/running), 3:done
	protected int progress;
	protected String message;
	protected int result;				//執行結果: //0: running, 1:success, -1:failure

	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public String getTxName() {
		return txName;
	}
	public void setTxName(String name) {
		this.txName = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getResult(){
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
}
