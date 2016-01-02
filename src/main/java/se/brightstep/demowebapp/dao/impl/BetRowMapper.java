package se.brightstep.demowebapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BetRowMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bet bet = new Bet();
		bet.setID(rs.getInt("ID"));
		bet.setMatchId(rs.getInt("match_ID"));
		bet.setUserId(rs.getInt("user_ID"));
		bet.setHomeScore(rs.getInt("home_score"));
		bet.setAwayScore(rs.getInt("away_score"));
		bet.setTimeOfBet(rs.getTimestamp("creation_time"));
		return bet;
	}

}
