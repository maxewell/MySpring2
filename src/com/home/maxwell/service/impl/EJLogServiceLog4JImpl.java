package com.home.maxwell.service.impl;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.maxwell.domain.EJLog;
import com.home.maxwell.service.EJLogService;

public class EJLogServiceLog4JImpl implements EJLogService{
	//protected Logger logger = Logger.getLogger(EJLogServiceLog4JImpl.class);
	protected static Logger log = LoggerFactory.getLogger(EJLogServiceLog4JImpl.class);
	protected AtomicLong id = new AtomicLong(0);
	
	public long getSequence(String string) {
		return id.getAndIncrement();
	}

	public void logEJ(EJLog logger) {
		long seqid = getSequence("");
		logger.setSequenceNo(seqid);
		
		if (log.isInfoEnabled()){
			log.info(logger.toString());
		}	
		
	}

	
}
