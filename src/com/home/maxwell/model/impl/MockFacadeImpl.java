package com.home.maxwell.model.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.maxwell.model.MockFacade;

public class MockFacadeImpl implements MockFacade{
	//protected static Logger logger = Logger.getLogger(MockFacadeImpl.class);
	protected static Logger logger = LoggerFactory.getLogger(MockFacadeImpl.class);
	
	public void doMockSomething(int data) {
		if (logger.isInfoEnabled()){
			logger.info("MockFacadeImple: doMockSomething: " + data + "||" + Thread.currentThread().getName());
		}	
	}

	public void doMockNothing(String data) {
		if (logger.isInfoEnabled()){
			logger.info("MockFacadeImple: doMockNothing: " + data + "||" + Thread.currentThread().getName());
		}	
	}

}
