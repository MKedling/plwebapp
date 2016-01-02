package se.brightstep.demowebapp.service.impl;

import java.util.List;

import se.brightstep.demowebapp.dao.BettingDAO;
import se.brightstep.demowebapp.dao.impl.Bet;
import se.brightstep.demowebapp.service.BettingService;

public class DefaultBettingService implements BettingService{

	private BettingDAO bettingDAO;
	
	public BettingDAO getBettingDAO() {
		return bettingDAO;
	}

	public void setBettingDAO(BettingDAO bettingDAO) {
		this.bettingDAO = bettingDAO;
	}

	public boolean placeBet(Bet bet) {
		
		return bettingDAO.placeBet(bet);
	}

	public List<Bet> getAllBets() {
		
		return bettingDAO.getAllBets();
	}


}
