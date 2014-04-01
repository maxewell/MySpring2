package com.home.maxwell.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.maxwell.model.MockFacade;

public class MockQuartzScheduleServiceImpl extends BaseQuartzScheduleServiceImpl{
	//protected static Logger logger = Logger.getLogger(MockQuartzScheduleServiceImpl.class);
	protected static Logger logger = LoggerFactory.getLogger(MockQuartzScheduleServiceImpl.class);
	protected MockFacade mockFacade;
	
	public MockFacade getMockFacade() {
		return mockFacade;
	}

	public void setMockFacade(MockFacade mockFacade) {
		this.mockFacade = mockFacade;
	}

	public void mock(Map<String, Object> map){
		String hi = (String)map.get("WELCOME");
		
		if (logger.isInfoEnabled()){
			logger.info("MockQuartzScheduleServiceImpl:" + hi);
		}	
	}
}
