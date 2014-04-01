package com.home.maxwell.domain;

import com.home.maxwell.ConstantKey;

public class EJLog {
	protected long sequenceNo;     		//流水序號
	protected long nowEnter;			//進入時間
	protected long nowLeave;			//離開時間
	protected long elaspedUsed;			//耗費時間
	protected String sessionId;			//sessionId
	protected String userId;			//使用者id
	protected String userIp;			//使用者IP
	protected String action;      		//Request URL
	protected String txnCode;			//交易別
	protected String method;       		//執行動作
	protected String channelId;			//來源別 (WebBrowser, 其他AppSystem, ...)
	protected String req;
	protected String resp;
	
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	
	public String getResp() {
		return resp;
	}
	public void setResp(String resp) {
		this.resp = resp;
	}
	public long getElaspedUsed() {
		return elaspedUsed;
	}
	public void setElaspedUsed(long elaspedUsed) {
		this.elaspedUsed = elaspedUsed;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public long getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(long sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	public long getNowLeave() {
		return nowLeave;
	}
	public void setNowLeave(long nowLeave) {
		this.nowLeave = nowLeave;
	}
	public long getNowEnter() {
		return nowEnter;
	}
	public void setNowEnter(long nowEnter) {
		this.nowEnter = nowEnter;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getTxnCode() {
		return txnCode;
	}
	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}
	
	public String toString(){
		StringBuffer sbf = new StringBuffer();
		sbf.append(String.valueOf(this.sequenceNo)).append(ConstantKey.BASE_COLON_STR);
		sbf.append(String.valueOf(this.nowEnter)).append(ConstantKey.BASE_COLON_STR);
		sbf.append(String.valueOf(this.nowLeave)).append(ConstantKey.BASE_COLON_STR);
		sbf.append(String.valueOf(this.elaspedUsed)).append(ConstantKey.BASE_COLON_STR);
		sbf.append(String.valueOf(this.action)).append(ConstantKey.BASE_COLON_STR);
		sbf.append(String.valueOf(this.userIp)).append(ConstantKey.BASE_COLON_STR);
		sbf.append(String.valueOf(this.userId)).append(ConstantKey.BASE_COLON_STR);
		sbf.append(String.valueOf(this.sessionId)).append(ConstantKey.BASE_COLON_STR);
		sbf.append(String.valueOf(this.req)).append(ConstantKey.BASE_COLON_STR);
		sbf.append(ConstantKey.BASE_LEFT_CURLY_BRACKETS_STR).append(String.valueOf(this.resp)).append(ConstantKey.BASE_RIGHT_CURLY_BRACKETS_STR).append(ConstantKey.BASE_COLON_STR);
		//sbf.append(String.valueOf(this.sequenceNo)).append(ConstantKey.BASE_COLON_STR);
		
		return sbf.toString();
	}
	
}
