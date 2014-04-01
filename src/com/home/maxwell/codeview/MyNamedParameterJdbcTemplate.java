package com.home.maxwell.codeview;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class MyNamedParameterJdbcTemplate extends NamedParameterJdbcTemplate {

	public MyNamedParameterJdbcTemplate(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}

}
