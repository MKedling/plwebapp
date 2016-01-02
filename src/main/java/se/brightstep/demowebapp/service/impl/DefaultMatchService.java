package se.brightstep.demowebapp.service.impl;

import java.util.List;

import se.brightstep.demowebapp.dao.MatchDAO;
import se.brightstep.demowebapp.dao.impl.Match;
import se.brightstep.demowebapp.service.MatchService;

public class DefaultMatchService implements MatchService{

	public MatchDAO getMatchDAO() {
		return matchDAO;
	}

	public void setMatchDAO(MatchDAO matchDAO) {
		this.matchDAO = matchDAO;
	}

	private MatchDAO matchDAO;
	
	public List<Match> getAllMatches() {
		
		return matchDAO.getAllMatches();
	}

}
