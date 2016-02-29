package se.brightstep.demowebapp.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import se.brightstep.demowebapp.dao.BettingDAO;
import se.brightstep.demowebapp.dao.MatchDAO;
import se.brightstep.demowebapp.dao.UserDAO;
import se.brightstep.demowebapp.dto.User;
import se.brightstep.demowebapp.dto.rowMapper.UserRowMapper;
import se.brightstep.demowebapp.session.UserSession;

public class DefaultUserDAO implements UserDAO{
	
	@Autowired
	protected UserSession userSession;
	
	@Autowired
	protected BettingDAO betDAO;
	
	@Autowired
	protected MatchDAO matchDAO;
	
	private JdbcTemplate jdbcTemplate;
	
	public enum Result{
		HOMEWIN, DRAW, AWAYWIN
	}
	
	public void setDataSource(final DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	public boolean login(String username, String password) {
		
		User user = getUserFromDB(username, password);
		
		if(user != null && user.password.equals(password)){
			userSession.setUser(user);
			return true;
		}
		
		return false;
		
	}


	public boolean createUser(String username, String password, String email) {
		
		if(getUserFromDB(username, password) != null){
			return false;
		}
		
	
		String insertQuery = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
	
		jdbcTemplate.update(insertQuery, new Object[] {username, password, email});
		
		User user = getUserFromDB(username, password);
		
		userSession.setUser(user);
		
		return true;
	}
	
	private User getUserFromDB(String username, String password){
		
		String query = "select * from users WHERE username = ?";
		
		User user;
		
		try{
		user = (User) jdbcTemplate.queryForObject(
							query, new Object[] { username } , new UserRowMapper());
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("User did not exist");
			return null;
		}
		
		return user;
	}


	@Override
	public List<User> getAllUsers() {
		
		String query = "SELECT * FROM users";
		List<User> allUsers = null;
		try{
			allUsers = (List<User>) jdbcTemplate.query(query, new UserRowMapper());
			}catch(org.springframework.dao.EmptyResultDataAccessException e){
				return null;
			}
	
		return allUsers;
	}


	@Override
	public int getUserId(String username) {
		String query = "SELECT id FROM users WHERE  username = ?";
		return jdbcTemplate.queryForObject(query, Integer.class, username);
	}

	


}
