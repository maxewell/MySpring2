package com.home.maxwell.service.impl;

import java.util.List;
import java.util.Map;

import com.home.maxwell.dao.AppEnvDao;
import com.home.maxwell.domain.AppEnv;
import com.home.maxwell.service.SystemService;

public class SystemServiceImpl implements SystemService{
	protected AppEnvDao appEnvDao;
	
	public List<AppEnv> getAppConfigValues(String value) {
		return appEnvDao.getAppEnvValues(value);
	}

	public AppEnvDao getAppEnvDao() {
		return appEnvDao;
	}

	public void setAppEnvDao(AppEnvDao appConfigDao) {
		this.appEnvDao = appConfigDao;
	}

}
