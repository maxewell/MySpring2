package com.home.maxwell.codeview;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class MySimpleJdbcTemplate extends SimpleJdbcTemplate {

	public MySimpleJdbcTemplate(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

}
