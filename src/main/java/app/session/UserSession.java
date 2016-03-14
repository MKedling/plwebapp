package app.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import app.dto.User;

import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS )
public class UserSession {
	
	private User user;
	
	private int round = 1;

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
