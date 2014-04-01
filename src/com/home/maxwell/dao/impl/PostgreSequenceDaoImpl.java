package com.home.maxwell.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.home.maxwell.dao.SequenceDao;

public class PostgreSequenceDaoImpl extends SqlMapClientDaoSupport implements SequenceDao{

	public int getNextId(String name) {
		Integer seq = (Integer) getSqlMapClientTemplate().queryForObject("Sequence.postgreSequence", name);
	    return seq;
	}

}
