package com.home.maxwell.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.home.maxwell.dao.DeptDao;
import com.home.maxwell.domain.Dept;

public class DeptDaoImpl extends SqlMapClientDaoSupport implements DeptDao{

	public void insertDept(Dept dept) {
		getSqlMapClientTemplate().insert("Dept.insertDept", dept);
	}

}
