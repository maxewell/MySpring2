package com.home.maxwell.service.impl;

import com.home.maxwell.dao.SequenceDao;
import com.home.maxwell.domain.EJLog;

public class EJLogServiceImpl {
	protected SequenceDao sequenceDao;
	
	public long getSequence(String name){
		return sequenceDao.getNextId(name);
	}

	public void insertEJLog(EJLog log) {
		
	}
	
	public SequenceDao getSequenceDao() {
		return sequenceDao;
	}

	public void setSequenceDao(SequenceDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}

	
	
}
