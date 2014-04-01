package com.home.maxwell.codeview;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;

public class MyAbstractApplicationContext extends AbstractApplicationContext {

	@Override
	protected void closeBeanFactory() {
		// TODO Auto-generated method stub

	}

	@Override
	public ConfigurableListableBeanFactory getBeanFactory()
			throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void refreshBeanFactory() throws BeansException,
			IllegalStateException {
		// TODO Auto-generated method stub

	}

}
