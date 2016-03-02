package se.brightstep.demowebapp.cronjob;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import se.brightstep.demowebapp.dto.json.Match;
import se.brightstep.demowebapp.service.EmailService;
import se.brightstep.demowebapp.service.MatchDayService;
import se.brightstep.demowebapp.service.MatchService;

public class CronJob {
	
	@Autowired
	protected MatchService matchService;
	
	@Autowired
	protected MatchDayService matchDayService;
	
	@Autowired
	protected EmailService emailService;
	
	private static int roundWhenLastExecuted = -1;
	
	//@Scheduled(cron="0 0 11 * * *")
	//@Scheduled(cron="*/30 * * * * ?")
    public void demoServiceMethod()
    {
		for(Integer i : addNewResults()){
			emailService.sendRoundSummary(i);
		}
    	
		
		/*
		if(checkIfRoundIsEnded()){
			checkIfResultIsAddedAndSendSummary();
		}
		*/
		
	}
	
	public List<Integer> addNewResults(){
		
		List<Integer> matchesToAdd = matchDayService.getMatchDaysToAddResult();
		for(Integer i : matchesToAdd){
			System.out.print(i + ", ");
			for(Match match : matchDayService.getMatchDay(i).getMatches()){
				matchService.addResult(match);
			}
		}
		matchesToAdd.removeAll(matchDayService.getMatchDaysToAddResult());
		return matchesToAdd; // Returnerar de matchDays som blev kompletta
		
	}
	
	/*
	public void checkIfResultIsAddedAndSendSummary(){
		if(checkIfRoundIsEnded()){
			emailService.sendRoundSummary(round);
		}
		
	}
	
	public boolean checkIfRoundIsEnded(){
		if(matchService.getCurrentRound() > roundWhenLastExecuted){
			roundWhenLastExecuted = matchService.getCurrentRound();
			return true;
		}
		return false;	
	}
	*/
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
