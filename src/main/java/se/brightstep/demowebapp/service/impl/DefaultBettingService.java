package se.brightstep.demowebapp.service.impl;

import java.util.List;

import se.brightstep.demowebapp.dao.BettingDAO;
import se.brightstep.demowebapp.dto.Bet;
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

	public List<Bet> getAllBetsRound(int id, int round){
		return bettingDAO.getAllBetsRound(id, round);
	}
	public List<Bet> getAllBets(int id){
		return bettingDAO.getAllBets(id);
	}

	@Override
	public List<Bet> getAllCompletedBets(int id) {
		return bettingDAO.getAllCompletedBets(id);
	}

	@Override
	public List<Bet> getAllCompletedBetsRound(int id, int round) {
		return bettingDAO.getAllCompletedBetsRound(id, round);
	}

	
	


}
