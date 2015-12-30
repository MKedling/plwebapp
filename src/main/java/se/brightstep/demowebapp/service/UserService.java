package se.brightstep.demowebapp.service;

public interface UserService {
	
	
	
	public boolean login(String username, String password);

	public boolean createUser(String username, String password, String email);
	
}
