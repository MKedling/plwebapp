package se.brightstep.demowebapp.dao;

import java.util.List;

import se.brightstep.demowebapp.dao.impl.Bet;

public interface BettingDAO {

	public boolean placeBet(Bet bet);

	public List<Bet> getAllBetsRound();
	public List<Bet> getAllBets();
}
