package com.home.maxwell.env;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author maxwell
 *
 * Fix-List:
 * 2014-03-04: 將查詢DB的作法由iBatis改為Spring JdbcTemplate，原因: 將此Component視為framework，不是AP。
 * 
 */
public class RtimeDbPropertiesFactoryBean implements FactoryBean {
	protected static String SELECT_APPENV_SQL_STR = 
		"SELECT APPNAME, ENVKEY, ENVVALUE FROM APPENV WHERE APPNAME = ?";
	
	protected JdbcTemplate jdbcTemplate;
	protected Properties properties;
	protected String appName;

	public void init(){
		this.properties = new Properties();
		jdbcTemplate.query(SELECT_APPENV_SQL_STR, new Object[]{appName}, new RowMapper(){

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				properties.put(rs.getString(2), rs.getString(3));
				return null;
			}
			
		});
	}
	
	public void cleanup(){
	}
	
	public Object getObject() throws Exception {
		return properties;
	}

	public Class getObjectType() {
		return java.util.Properties.class;
	}

	public boolean isSingleton() {
		return true;
	}
	
	public void setDataSource(DataSource dataSource){
		if (dataSource != null){
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
	}
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
}
