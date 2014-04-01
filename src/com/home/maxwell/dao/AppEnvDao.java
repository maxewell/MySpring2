package com.home.maxwell.dao;

import java.util.List;
import java.util.Map;

import com.home.maxwell.domain.AppEnv;

public interface AppEnvDao {

	List<AppEnv> getAppEnvValues(String value);

}
