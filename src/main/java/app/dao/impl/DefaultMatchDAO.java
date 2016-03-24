package app.dao.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.dao.MatchDAO;
import app.json.Match;
import app.json.MatchDay;
import app.rowMapper.MatchRowMapper;
import app.session.UserSession;

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
			System.out.println("LOG: User did not exist");
			return null;
		}
		Collections.sort(allMatches);
		return allMatches;
	}

	public List<Match> getAllMatchesToBet(int round) {
		
		String query = "SELECT * FROM matches WHERE id NOT IN (SELECT match_id FROM bet where user_ID = ?) AND round = ? AND start_time >= now()";
		List<Match> allMatchesToBet;
		
		try{
			allMatchesToBet = jdbcTemplate.query(query, new MatchRowMapper(), userSession.getUser().getID(), round);
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("LOG: No matches");
			return null;
		}
		
		Collections.sort(allMatchesToBet);
		
		return allMatchesToBet;
	}

	@Override
	public void addNewMatchesToDatabase(ArrayList<Match> allMatches) {
		
		for(Match match : allMatches){
		
			if(!matchExist(match)){
				jdbcTemplate.update("INSERT INTO matches(start_time, round, home_team, away_team) VALUES (?, ?, ?, ?)",
					     new Object[] { match.getStarttime(), match.getRound(), match.getHomeTeam(), match.getAwayTeam()  });
			}else{
				System.out.println("LOG: Match already exists: " + match);
			}
		}
		
	}
	
	public boolean matchExist(Match match){
		Integer cnt = jdbcTemplate.queryForObject(
			    "SELECT count(*) FROM matches WHERE home_team = ? AND away_team = ? AND round = ?", Integer.class, match.getHomeTeam(), match.getAwayTeam(), match.getRound());
			return cnt != null && cnt > 0;
	}
	
	public boolean matchWithoutResultExist(int matchID){
		Integer cnt = jdbcTemplate.queryForObject(
			    "SELECT count(*) FROM matches WHERE id = ? AND (home_score IS NULL OR away_score IS NULL)", Integer.class, matchID);
			return cnt != null && cnt > 0;
	}

	@Override
	public int getCurrentRound() {
		try{
			return jdbcTemplate.queryForObject("SELECT round FROM matches WHERE start_time >= now() ORDER BY round ASC LIMIT 1", Integer.class);
		}catch(EmptyResultDataAccessException e){
			return -1;
		}
	}

	@Override
	public List<Match> getAllMatchesToAddResult() {
		
		String query = "SELECT * FROM matches WHERE start_time < now() AND (home_score IS NULL OR away_score IS NULL)";
		List<Match> allMatchesToAddResult;
		
		try{
			allMatchesToAddResult = jdbcTemplate.query(query, new MatchRowMapper());
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("LOG: No matches");
			return null;
		}
		
		return allMatchesToAddResult;
	}

	@Override
	public boolean addResult(int matchID, int homeScore, int awayScore) {
		
		if(matchWithoutResultExist(matchID)){
			jdbcTemplate.update("UPDATE matches SET home_score = ?, away_score = ? WHERE id = ?", homeScore, awayScore, matchID);
			System.out.println("LOG: Added result matchid: " + matchID);
			return true;
		}
		System.out.println("LOG: Match resultat ej uppdaterat, kanske redan finns? match id:" + matchID);
		return false;
	}
	
	@Override
	public boolean addResult(Match match) {
		if(match.getStatus().equals("FINISHED")){
			return addResult(	match.getID(), 
								match.getResult().getHomeScore(), 
								match.getResult().getAwayScore()
								);
			}
		
		return false;
	}

	@Override
	public MatchDay getMatchDay(int round) {
		ObjectMapper mapper = new ObjectMapper();
		String url = "http://api.football-data.org/v1/soccerseasons/398/fixtures?matchday=" + round;
		
		try {
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			//Inte saker pa att denna funger aeller inte
			con.setRequestProperty("header", "X-Auth-Token: 60cdd65ef44b4e04ab16b18b29308a5a");
			
			MatchDay matchDay =  mapper.readValue(new URL(url), MatchDay.class);
			
			for(Match match : matchDay.getMatches()){
				populateID(match);
			}
			return matchDay;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void populateID(MatchDay matchDay){
		
	}
	
	public void populateID(Match match){
		int id = getMatchID(match);
		if(id != -1){
			match.setID(getMatchID(match));
		}else{
			System.out.println("LOG: id for match: " + match + "  finns inte i databasen");
		}
	}
	
	// vad hander om ingen match finns?
	public int getMatchID(Match match){
		if(matchExist(match)){
			return jdbcTemplate.queryForObject(
				    "SELECT ID FROM matches WHERE home_team = ? AND away_team = ? AND round = ?", 
				    Integer.class, match.getHomeTeam(), match.getAwayTeam(), match.getRound());
		}else{
			return -1;
		}
		
		
	}

	@Override
	public List<Integer> getMatchDaysToAddResult() {
		String query = "select round from matches where (home_score OR away_score) IS NULL AND start_time < NOW() GROUP BY round";
		return jdbcTemplate.queryForList(query, Integer.class);
	}
	
	
	public Match getMatch(String homeTeam, String awayTeam) {
	
		String query = "SELECT * FROM matches WHERE home_team = ? AND away_team = ?";
			
		try{
			return (Match) jdbcTemplate.queryForObject(query, new MatchRowMapper(), homeTeam, awayTeam);
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("LOG: No Match");
			return null;
		}
	}
	
	public Match getMatch(int id) {
		
		String query = "SELECT * FROM matches WHERE id = ?";
		try{
			return (Match) jdbcTemplate.queryForObject(query, new MatchRowMapper(), id);
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("LOG: No Match");
			return null;
		}
	}

	
	

}
