package app.cronjob;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import app.json.Match;
import app.service.EmailService;
import app.service.MatchDayService;
import app.service.MatchService;

public class CronJob {
	
	@Autowired
	protected MatchService matchService;
	
	@Autowired
	protected MatchDayService matchDayService;
	
	@Autowired
	protected EmailService emailService;
	
	private static int roundWhenLastExecuted = -1;
	
	@Scheduled(cron="0 0 11 * * *")
	//@Scheduled(cron="*/30 * * * * ?")
    public void demoServiceMethod()
    {
		for(Integer i : addNewResults()){
			emailService.sendRoundSummary(i);
		}
    	
		
	}
	
	public List<Integer> addNewResults(){
		
		List<Integer> matchesToAdd = matchDayService.getMatchDaysToAddResult();
		for(Integer i : matchesToAdd){
			System.out.println("LOG: Matchday " + i + " not complete yet ");
			for(Match match : matchDayService.getMatchDay(i).getMatches()){
				matchService.addResult(match);
			}
		}
		matchesToAdd.removeAll(matchDayService.getMatchDaysToAddResult());
		return matchesToAdd; // Returnerar de matchDays som blev kompletta
		
	}
	
	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	

}
