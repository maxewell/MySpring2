package com.home.maxwell.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.home.maxwell.dao.SequenceDao;
import com.home.maxwell.domain.Sequence;

public class DB2SequenceDaoImpl extends SqlMapClientDaoSupport implements SequenceDao{

	public int getNextId(String name) {
		Integer seq = (Integer)getSqlMapClientTemplate().queryForObject("Sequence.db2Sequence", name);
		return seq;
	}

}
