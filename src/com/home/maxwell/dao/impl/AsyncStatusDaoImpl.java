package com.home.maxwell.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.home.maxwell.dao.AsyncStatusDao;
import com.home.maxwell.service.AsyncStatus;

public class AsyncStatusDaoImpl extends SqlMapClientDaoSupport implements AsyncStatusDao{

	public void update(AsyncStatus status) {
		getSqlMapClientTemplate().update("ASYNCSTATUS.update", status);
	}

	public void insert(AsyncStatus status) {
		getSqlMapClientTemplate().insert("ASYNCSTATUS.insert", status);
	}

}
