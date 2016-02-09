package se.brightstep.demowebapp.dao.impl;

import java.util.ArrayList;
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
		
		String query = "SELECT * FROM Matches WHERE id NOT IN (SELECT match_id FROM bet where user_ID = ?) AND round = ? AND start_time >= now()";
		List<Match> allMatchesToBet;
		
		try{
			allMatchesToBet = jdbcTemplate.query(query, new MatchRowMapper(), userSession.getUser().getID(), userSession.getRound());
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("User did not exist");
			return null;
		}
		
		return allMatchesToBet;
	}

	@Override
	public void addNewMatchesToDatabase(ArrayList<Match> allMatches) {
		
		for(Match match : allMatches){
		
			if(!matchExist(match)){
				jdbcTemplate.update("INSERT INTO matches(start_time, round, home_team, away_team) VALUES (?, ?, ?, ?)",
					     new Object[] { match.getStarttime(), match.getRound(), match.getHomeTeam(), match.getAwayTeam()  });
			}else{
				System.out.println("Match already exists: " + match);
			}
		}
		
	}
	
	public boolean matchExist(Match match){
		Integer cnt = jdbcTemplate.queryForObject(
			    "SELECT count(*) FROM matches WHERE home_team = ? AND away_team = ? AND round = ?", Integer.class, match.getHomeTeam(), match.getAwayTeam(), match.getRound());
			return cnt != null && cnt > 0;
	}

	@Override
	public int getCurrentRound() {
		
		String round = jdbcTemplate.queryForList("SELECT round FROM matches WHERE start_time >= now() ORDER BY round ASC").get(0).toString();
		
		return Integer.parseInt(round.replaceAll("[^0-9]", ""));
	}
	

}
