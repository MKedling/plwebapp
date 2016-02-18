package se.brightstep.demowebapp.dto;


public class HighscoreEntry implements Comparable<HighscoreEntry>{

	User user;
	int score;
	
	public HighscoreEntry(User user, int score) {
		this.user = user;
		this.score = score;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	} 
	
	@Override
	public int compareTo(HighscoreEntry highscoreentry){
		return highscoreentry.score - this.score;
	}
	
}
