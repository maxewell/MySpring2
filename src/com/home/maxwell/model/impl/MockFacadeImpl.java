package com.home.maxwell.model.impl;



import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.maxwell.helper.ThreadLocalHelper;
import com.home.maxwell.model.MockFacade;

public class MockFacadeImpl implements MockFacade{
	//protected static Logger logger = Logger.getLogger(MockFacadeImpl.class);
	protected static Logger logger = LoggerFactory.getLogger(MockFacadeImpl.class);
	
	public void doMockSomething(int data) {
		if (logger.isInfoEnabled()){
			logger.info("MockFacadeImple: doMockSomething: " + data + "||" + Thread.currentThread().getName());
		}	
		InputStream is = ThreadLocalHelper.getResourceAsStream("WEB-INF/web.xml");
	}

	public void doMockNothing(String data) {
		if (logger.isInfoEnabled()){
			logger.info("MockFacadeImple: doMockNothing: " + data + "||" + Thread.currentThread().getName());
		}	
	}

}
