package se.brightstep.demowebapp.dto.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import se.brightstep.demowebapp.dto.Bet;

public class BetRowMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bet bet = new Bet();
		bet.setBetID(rs.getInt("bet_id"));
		bet.setMatchID(rs.getInt("match_ID"));
		bet.setUserID(rs.getInt("user_ID"));
		
		bet.setHomeTeam(rs.getString("home_team"));
		bet.setAwayTeam(rs.getString("away_team"));
		
		bet.setMatchHomeScore(rs.getInt("match_home_score"));
		bet.setMatchAwayScore(rs.getInt("match_away_score"));
		if(rs.wasNull()){
			bet.setMatchHomeScore(null);
			bet.setMatchAwayScore(null);
		}
		
		bet.setBetHomeScore(rs.getInt("bet_home_score"));
		bet.setBetAwayScore(rs.getInt("bet_away_score"));
		
		bet.setStarttime(rs.getTimestamp("start_time"));
		bet.setTimeOfBet(rs.getTimestamp("creation_time"));
		bet.setRound(rs.getInt("round"));
		
		return bet;
	}

}
