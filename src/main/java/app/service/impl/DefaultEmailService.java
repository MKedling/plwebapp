package app.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import app.dto.HighscoreEntry;
import app.dto.User;
import app.service.EmailService;
import app.service.ScoreService;
import app.service.UserService;


public class DefaultEmailService implements EmailService{

	@Autowired
	protected ScoreService scoreService;
	@Autowired
	protected UserService userService;
	
	@Override
	public void sendRoundSummary(int round) {
		StringBuilder emailContent = createEmailContent(round);
		
		String server ="smtp.gmail.com";
		String username ="m.kedling@gmail.com";
		String password ="mattias1";

		for(User user : userService.getAllUsers()){
			sendMail(server,username, password, "chefen",  user.getEmail(), "Summering runda: " + round, emailContent.toString());
		}
	}
	
	
	private StringBuilder createEmailContent(int round){
		
		StringBuilder sb = new StringBuilder();
		sb.append("Summering runda " + round + ":\n");
		for(HighscoreEntry entry : scoreService.getRoundHighscore(round)){
			sb.append(entry.getUser().getUsername() + " : " + entry.getScore()+ "\n");
		}
		
		sb.append("\n\n");
		
		sb.append("Total highscore:\n");
		for(HighscoreEntry entry : scoreService.getTotalHighscore()){
			sb.append(entry.getUser().getUsername() + " : " + entry.getScore()+ "\n");
		}
		
		
		return sb;
	}
	

	
	private void sendMail(String server, final String username, final String password, String from, String to, String subject, String msg){
		
		Properties props = new Properties();
		props.put("mail.smtp.host", server); // Sätter servern
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Bestämmer vilken klass som skall användas vid skapandet av smtp socket
		props.put("mail.smtp.socketFactory.port", "465"); // Bestämmer porten då man angett en specifik klass
		props.put("mail.smtp.auth", "true"); // Kör AUTH command
		
		//Skapar ett session och "Authenticates it"
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
 
		try {
			// Skapar ett meddelande och sätter från, mottagare, ämne, meddelande
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(msg);
 
			//Sänder
			Transport.send(message);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}		
	}
        
     

}
