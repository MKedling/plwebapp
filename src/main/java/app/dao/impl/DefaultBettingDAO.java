package app.dao.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import app.dao.BettingDAO;
import app.dto.Bet;
import app.json.Match;
import app.rowMapper.BetRowMapper;
import app.service.MatchService;
import app.session.UserSession;

public class DefaultBettingDAO implements BettingDAO{

	@Autowired
	protected UserSession userSession;
	
	@Autowired
	protected MatchService matchService;
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(final DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean placeBet(Bet bet) {
		
		if(betExist(bet)){
			System.out.println("LOG: Bet exist " + bet);
			return false;
		}
		
		if(matchService.getMatch(bet.getMatchID()).getStarttime().before(new Date())){
			System.out.println("LOG: bet cant be placed, match starttime has already been");
			return false;
		}
	
		int affected = jdbcTemplate.update("INSERT INTO bet(match_ID, user_ID, home_score, away_score) VALUES (?, ?, ?, ?)",
			     new Object[] { bet.getMatchID(), bet.getUserID(), bet.getBetHomeScore(), bet.getBetAwayScore()  });
		
		System.out.println("LOG: placed bet query was runned, BET= " + bet + "  affected rows= " + affected);
		
		return true;
	}

	public List<Bet> getAllBetsRound(int id, int round) {
		String query = "SELECT matches.id as match_id, matches.home_team as home_team, matches.away_team as away_team,matches.home_score as match_home_score,matches.away_score as match_away_score,matches.start_time as start_time, matches.round as round ,bet.id as bet_id,bet.home_score as bet_home_score,bet.away_score as bet_away_score, bet.user_ID as user_id, bet.creation_time as creation_time FROM matches INNER JOIN bet ON matches.ID=bet.match_ID WHERE (user_id = ? AND round = ?);";
		return getBetsRound(query, id, round);
	}
	
	public List<Bet> getAllBets(int id) {
		String query = "SELECT matches.id as match_id, matches.home_team as home_team, matches.away_team as away_team,matches.home_score as match_home_score,matches.away_score as match_away_score,matches.start_time as start_time, matches.round as round ,bet.id as bet_id,bet.home_score as bet_home_score,bet.away_score as bet_away_score, bet.user_ID as user_id, bet.creation_time as creation_time FROM matches INNER JOIN bet ON matches.ID=bet.match_ID WHERE user_id = ?;";
		return getBets(query, id);
	}
	
	@Override
	public List<Bet> getAllCompletedBetsRound(int id, int round) {
		String query = "SELECT matches.id as match_id, matches.home_team as home_team, matches.away_team as away_team,matches.home_score as match_home_score,matches.away_score as match_away_score,matches.start_time as start_time, matches.round as round ,bet.id as bet_id,bet.home_score as bet_home_score,bet.away_score as bet_away_score, bet.user_ID as user_id, bet.creation_time as creation_time FROM matches INNER JOIN bet ON matches.ID=bet.match_ID WHERE user_id = ? AND round = ? AND (matches.home_score is not null OR matches.away_score is not null)";
		return getBetsRound(query, id, round);
	}

	@Override
	public List<Bet> getAllCompletedBets(int id) {
		String query = "SELECT matches.id as match_id, matches.home_team as home_team, matches.away_team as away_team,matches.home_score as match_home_score,matches.away_score as match_away_score,matches.start_time as start_time, matches.round as round ,bet.id as bet_id,bet.home_score as bet_home_score,bet.away_score as bet_away_score, bet.user_ID as user_id, bet.creation_time as creation_time FROM matches INNER JOIN bet ON matches.ID=bet.match_ID WHERE user_id = ? AND (matches.home_score is not null OR matches.away_score is not null)";
		return getBets(query, id);
	}
	
	@Override
	public List<Bet> getAllStartedBetsRound(int id, int round) {
		String query = "SELECT matches.id as match_id, matches.home_team as home_team, matches.away_team as away_team,matches.home_score as match_home_score,matches.away_score as match_away_score,matches.start_time as start_time, matches.round as round ,bet.id as bet_id,bet.home_score as bet_home_score,bet.away_score as bet_away_score, bet.user_ID as user_id, bet.creation_time as creation_time FROM matches INNER JOIN bet ON matches.ID=bet.match_ID WHERE user_id = ? AND round = ? AND matches.start_time < NOW()";
		return getBetsRound(query, id, round);
	}
	
	private List<Bet> getBets(String query, int id){
		
		List<Bet> allBets;
		
		try{
			allBets = jdbcTemplate.query(query, new BetRowMapper(), id);
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("LOG: Bet did not exist");
			return null;
		}
		
		Collections.sort(allBets);
		return allBets;
		
	}
	
	private List<Bet> getBetsRound(String query, int id ,int round){
		List<Bet> allBets;
		
		try{
			allBets = jdbcTemplate.query(query, new BetRowMapper(), id, round);
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("LOG: Bet did not exist");
			return null;
		}
		
		Collections.sort(allBets);
		return allBets;
	}
	
	public boolean betExist(Bet bet){
		Integer cnt = jdbcTemplate.queryForObject(
			    "SELECT count(*) FROM bet WHERE match_id = ? AND user_id = ?", Integer.class, bet.getMatchID(), bet.getUserID());
			return cnt != null && cnt > 0;
	}

	

	

	
}
