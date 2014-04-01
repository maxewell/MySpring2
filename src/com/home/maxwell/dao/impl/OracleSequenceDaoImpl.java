package com.home.maxwell.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.home.maxwell.dao.SequenceDao;
import com.home.maxwell.domain.Sequence;

public class OracleSequenceDaoImpl extends SqlMapClientDaoSupport implements SequenceDao{

	public int getNextId(String name) {
		Sequence sequence = new Sequence();
	    sequence.setName(name);
	    sequence = (Sequence) getSqlMapClientTemplate().queryForObject("Sequence.oracleSequence", sequence);
	    return sequence.getNextId();
	}

}
