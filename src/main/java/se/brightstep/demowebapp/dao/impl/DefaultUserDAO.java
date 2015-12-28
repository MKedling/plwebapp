package se.brightstep.demowebapp.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import se.brightstep.demowebapp.dao.UserDAO;

public class DefaultUserDAO implements UserDAO{
	
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(final DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	public boolean login(String username, String password) {
		
		String query = "select * from users where username ='"+username+"'" +" AND password='"+ password +"'";
		
		List<Map<String, Object>> users = jdbcTemplate.queryForList(query);
		
		return !users.isEmpty();
	}

}
