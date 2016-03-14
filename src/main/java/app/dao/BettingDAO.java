package app.dao;

import java.util.List;

import app.dto.Bet;

public interface BettingDAO {

	public boolean placeBet(Bet bet);

	public List<Bet> getAllBetsRound(int id, int round);
	public List<Bet> getAllBets(int id);

	public List<Bet> getAllCompletedBetsRound(int id, int round);
	public List<Bet> getAllCompletedBets(int id);

	public List<Bet> getAllStartedBetsRound(int id, int round);

}
