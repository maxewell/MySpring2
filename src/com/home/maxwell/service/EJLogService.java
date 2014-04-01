package com.home.maxwell.service;

import com.home.maxwell.domain.EJLog;

public interface EJLogService {
	long getSequence(String string);
	void logEJ(EJLog log);
}
