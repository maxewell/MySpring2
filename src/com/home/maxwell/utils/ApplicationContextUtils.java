/**
 * 
 */
package com.home.maxwell.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author maxwell
 *
 *  use WebApplicationContextUtils in spring
 */
@Deprecated 
public class ApplicationContextUtils implements ApplicationContextAware{
	protected static ApplicationContext ctx;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ctx = applicationContext;
	}

}
