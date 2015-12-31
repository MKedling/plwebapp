package se.brightstep.demowebapp.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

import se.brightstep.demowebapp.dao.impl.User;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS )
public class UserSession {
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
