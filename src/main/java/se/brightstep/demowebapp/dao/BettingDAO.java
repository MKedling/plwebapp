package se.brightstep.demowebapp.dao;

import java.util.List;

import se.brightstep.demowebapp.dto.Bet;

public interface BettingDAO {

	public boolean placeBet(Bet bet);

	public List<Bet> getAllBetsRound(int id, int round);
	public List<Bet> getAllBets(int id);

	public List<Bet> getAllCompletedBetsRound(int id, int round);
	public List<Bet> getAllCompletedBets(int id);
}
