package com.home.maxwell.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.home.maxwell.dao.AppEnvDao;
import com.home.maxwell.domain.AppEnv;

public class AppEnvDaoImpl extends SqlMapClientDaoSupport implements AppEnvDao{

	public List<AppEnv> getAppEnvValues(String value) {
		return (List<AppEnv>)getSqlMapClientTemplate().queryForList("AppEnv.getAppEnvValues", value);
	}

}
