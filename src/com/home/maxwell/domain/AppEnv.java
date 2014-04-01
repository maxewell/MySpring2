package com.home.maxwell.domain;

public class AppEnv {
	protected String envKey;
	protected String envValue;
	protected String appName;
	
	public String getAppName() {
		return appName;
	}
	public String getEnvKey() {
		return envKey;
	}
	public void setEnvKey(String envKey) {
		this.envKey = envKey;
	}
	public String getEnvValue() {
		return envValue;
	}
	public void setEnvValue(String envValue) {
		this.envValue = envValue;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	
}
