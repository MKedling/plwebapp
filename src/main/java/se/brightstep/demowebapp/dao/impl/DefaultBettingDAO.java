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
			     new Object[] { bet.getMatchId(), bet.getUserId(), bet.getHomeScore(), bet.getAwayScore()  });
		
		return false;
	}
	
	public List<Bet> getAllBets() {
		
		String query = "select * from bet where user_id = ?";
		
		List<Bet> allBets;
		
		try{
			allBets = jdbcTemplate.query(query, new BetRowMapper(), userSession.getUser().getID());
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("Bet did not exist");
			return null;
		}
		
		return allBets;
	}
	
	public boolean betExist(Bet bet){
		Integer cnt = jdbcTemplate.queryForObject(
			    "SELECT count(*) FROM bet WHERE match_id = ? AND user_id = ?", Integer.class, bet.getMatchId(), userSession.getUser().getID());
			return cnt != null && cnt > 0;
	}

	
}
