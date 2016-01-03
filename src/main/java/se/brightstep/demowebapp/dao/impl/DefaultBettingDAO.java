package se.brightstep.demowebapp.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import se.brightstep.demowebapp.dao.BettingDAO;
import se.brightstep.demowebapp.session.UserSession;

public class DefaultBettingDAO implements BettingDAO{

	@Autowired
	protected UserSession userSession;
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(final DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean placeBet(Bet bet) {
		
		if(betExist(bet)){
			System.out.println("Bet exist: with match id already exists");
			return false;
		}
		
		jdbcTemplate.update("INSERT INTO bet(match_ID, user_ID, home_score, away_score) VALUES (?, ?, ?, ?)",
			     new Object[] { bet.getMatchID(), bet.getUserID(), bet.getBetHomeScore(), bet.getBetAwayScore()  });
		
		return false;
	}
	
	public List<Bet> getAllBets() {
		
		String query = "SELECT Matches.id as match_id, Matches.home_team as home_team, Matches.away_team as away_team,Matches.home_score as match_home_score,Matches.away_score as match_away_score,Matches.start_time as start_time, Matches.round as round ,Bet.id as bet_id,Bet.home_score as bet_home_score,Bet.away_score as bet_away_score, Bet.user_ID as user_id, Bet.creation_time as creation_time FROM Matches INNER JOIN Bet ON Matches.ID=Bet.match_ID WHERE user_id = ? AND round = ?;";
		
		List<Bet> allBets;
		
		try{
			allBets = jdbcTemplate.query(query, new BetRowMapper(), userSession.getUser().getID(), userSession.getRound());
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("Bet did not exist");
			return null;
		}
		
		return allBets;
	}
	
	public boolean betExist(Bet bet){
		Integer cnt = jdbcTemplate.queryForObject(
			    "SELECT count(*) FROM bet WHERE match_id = ? AND user_id = ?", Integer.class, bet.getMatchID(), userSession.getUser().getID());
			return cnt != null && cnt > 0;
	}

	
}
