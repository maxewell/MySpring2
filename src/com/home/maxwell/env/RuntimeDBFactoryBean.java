package com.home.maxwell.env;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.home.maxwell.domain.AppEnv;
import com.home.maxwell.service.SystemService;

@Deprecated
public class RuntimeDBFactoryBean implements FactoryBean, InitializingBean{
	protected static final Logger logger = LoggerFactory.getLogger(RuntimeDBFactoryBean.class);
			
	protected Properties properties;
	
	protected String appName;	
	protected SystemService systemService;

	public Object getObject() throws Exception {
		return properties;
	}

	public Class getObjectType() {
		return java.util.Properties.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void afterPropertiesSet() throws Exception {
		properties = new Properties(); 
		
		List<AppEnv> lists = this.systemService.getAppConfigValues(this.appName);
		for (AppEnv bean : lists){
			properties.put(bean.getEnvKey(), bean.getEnvValue());
		}
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
}
