package se.brightstep.demowebapp.service;

import java.util.List;

import se.brightstep.demowebapp.dao.impl.Bet;

public interface BettingService {

	public boolean placeBet(Bet bet);
	
	public List<Bet> getAllBets(int id);
	public List<Bet> getAllBetsRound(int id, int round);

}
