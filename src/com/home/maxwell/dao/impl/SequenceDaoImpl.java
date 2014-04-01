package com.home.maxwell.dao.impl;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.home.maxwell.dao.SequenceDao;
import com.home.maxwell.domain.Sequence;

public class SequenceDaoImpl extends SqlMapClientDaoSupport implements SequenceDao{

	public int getNextId(String name) {
		Sequence sequence = new Sequence(name, -1);
	    sequence = (Sequence) getSqlMapClientTemplate().queryForObject("Sequence.getSequence", sequence);
	    if (sequence == null) {
	      throw new DataRetrievalFailureException(
						"Could not get next value of sequence '" + name + "': sequence does not exist");
	    }
	    Object parameterObject = new Sequence(name, sequence.getNextId() + 1);
	    getSqlMapClientTemplate().update("Sequence.updateSequence", parameterObject, 1);
	    return sequence.getNextId();
	}

}
