package se.brightstep.demowebapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MatchRowMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Match match = new Match();
		match.setID(rs.getInt("ID"));
		match.setHomeTeam(rs.getString("home_team"));
		match.setAwayTeam(rs.getString("away_team"));
		match.setHomeScore(rs.getInt("home_score"));
		match.setAwayScore(rs.getInt("away_score"));
		match.setStarttime(rs.getTimestamp("start_time"));
		match.setRound(rs.getInt("round"));
		return match;
	}

}
