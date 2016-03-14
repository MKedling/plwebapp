package app.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import app.json.Match;
import app.json.Result;

public class MatchRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Match match = new Match();
		Result result = new Result();
		match.setID(rs.getInt("ID"));
		match.setHomeTeam(rs.getString("home_team"));
		match.setAwayTeam(rs.getString("away_team"));
		match.setRound(rs.getInt("round"));
		match.setStarttime(rs.getTimestamp("start_time"));
		match.setResult(result);
		result.setHomeScore(rs.getInt("home_score"));
		result.setAwayScore(rs.getInt("away_score"));
		
		
		
		
		return match;
	}

}
