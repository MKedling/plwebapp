package se.brightstep.demowebapp.dao.impl;

import java.sql.PreparedStatement;
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
		System.out.println("Login q: " + query);
		List<Map<String, Object>> users = jdbcTemplate.queryForList(query);
		return !users.isEmpty();
	}


	public boolean createUser(String username, String password, String email) {
		
		String selectQuery = "select * from users where username ='"+username+"'" +" AND password='"+ password +"'";
		
		if(jdbcTemplate.queryForList(selectQuery).size() < 0){
			System.out.println("Användare finns redan!");
			return false;
		}
		
		String insertQuery = "INSERT INTO users (username, password, email) VALUES ('" + username + "', '" + password +"', '" + email + "')";
		
		jdbcTemplate.execute(insertQuery);
		
		
		return false;
	}

}
