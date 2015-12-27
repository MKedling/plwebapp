package se.brightstep.demowebapp.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import se.brightstep.demowebapp.dao.ExampleDAO;

public class DefaultExampleDAO implements ExampleDAO {
	
	private JdbcTemplate jdbcTemplate;

	public String getSampleData() {
		return jdbcTemplate.queryForObject("select sampledata from sampledata where id=1", String.class);
		//return jdbcTemplate.queryForObject("select p_image from products where id=1", String.class);
	}
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
