package se.brightstep.demowebapp.service.impl;

import java.util.List;

import se.brightstep.demowebapp.dao.MatchDAO;
import se.brightstep.demowebapp.dto.json.Match;
import se.brightstep.demowebapp.dto.json.MatchDay;
import se.brightstep.demowebapp.service.MatchService;

public class DefaultMatchService implements MatchService{

	private MatchDAO matchDAO;
	
	public MatchDAO getMatchDAO() {
		return matchDAO;
	}

	public void setMatchDAO(MatchDAO matchDAO) {
		this.matchDAO = matchDAO;
	}
	
	public List<Match> getAllMatches() {
		return matchDAO.getAllMatches();
	}

	public List<Match> getAllMatchesToBet(int round) {
		return matchDAO.getAllMatchesToBet(round);
	}

	@Override
	public int getCurrentRound() {
		return matchDAO.getCurrentRound();
	}

	@Override
	public List<Match> getAllMatchesToAddResult() {
		
		return matchDAO.getAllMatchesToAddResult();
	}

	@Override
	public boolean addResult(int matchID, int homeScore, int awayScore) {
		return matchDAO.addResult(matchID, homeScore, awayScore);
		
	}
	
	@Override
	public boolean addResult(Match match) {
		// TODO Auto-generated method stub
		return matchDAO.addResult(match);
	}

	@Override
	public MatchDay getMatchDay(int round) {
		return matchDAO.getMatchDay(round);
	}

	@Override
	public Match getMatch(String homeTeam, String awayTeam) {
		return matchDAO.getMatch(homeTeam, awayTeam);
	}

	

}
