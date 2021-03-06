package com.home.maxwell.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.home.maxwell.dao.AsyncStatusDao;
import com.home.maxwell.domain.TxStatusImpl;
import com.home.maxwell.service.AsyncStatus;
import com.home.maxwell.service.TxStatus;

public class AsyncStatusDaoImpl extends SqlMapClientDaoSupport implements AsyncStatusDao{

	public void update(AsyncStatus status) {
		getSqlMapClientTemplate().update("ASYNCSTATUS.update", status);
	}

	public void insert(AsyncStatus status) {
		getSqlMapClientTemplate().insert("ASYNCSTATUS.insert", status);
	}

	public List<TxStatus> queryTxStatusList(String userId, String txName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("txName", txName);
		
		return getSqlMapClientTemplate().queryForList("ASYNCSTATUS.queryTxStatusList", map);
	}

	public TxStatus queryTxStatus(String userId, String txName, String statusId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("txName", txName);
		map.put("statusId", statusId);
		return (TxStatus)getSqlMapClientTemplate().queryForObject("ASYNCSTATUS.queryTxStatus", map);
	}

}
