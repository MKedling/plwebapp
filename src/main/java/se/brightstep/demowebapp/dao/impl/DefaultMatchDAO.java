package se.brightstep.demowebapp.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import se.brightstep.demowebapp.dao.MatchDAO;
import se.brightstep.demowebapp.session.UserSession;

public class DefaultMatchDAO implements MatchDAO{

	@Autowired
	protected UserSession userSession;
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(final DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Match> getAllMatches() {
		String query = "select * from matches";
		
		List<Match> allMatches;
		
		try{
			allMatches = jdbcTemplate.query(query, new MatchRowMapper());
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("User did not exist");
			return null;
		}
		
		return allMatches;
	}

	public List<Match> getAllMatchesToBet() {
		
		String query = "SELECT * FROM Matches WHERE id NOT IN (SELECT match_id FROM bet where user_ID = ?)";
		List<Match> allMatchesToBet;
		
		try{
			allMatchesToBet = jdbcTemplate.query(query, new MatchRowMapper(), userSession.getUser().getID());
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("User did not exist");
			return null;
		}
		
		return allMatchesToBet;
	}

}
