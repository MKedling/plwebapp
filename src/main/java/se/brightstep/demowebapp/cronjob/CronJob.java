package se.brightstep.demowebapp.cronjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import se.brightstep.demowebapp.service.EmailService;
import se.brightstep.demowebapp.service.MatchService;

public class CronJob {
	
	@Autowired
	protected MatchService matchService;
	
	@Autowired
	protected EmailService emailService;
	
	private static int roundWhenLastExecuted = -1;
	
	@Scheduled(cron="0 0 11 * * *")
    public void demoServiceMethod()
    {
		int round =  matchService.getCurrentRound();
		if(roundWhenLastExecuted < round){
			roundWhenLastExecuted = matchService.getCurrentRound();
			emailService.sendRoundSummary(round);
		}
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
