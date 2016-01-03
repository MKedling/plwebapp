package se.brightstep.demowebapp.dao;

public interface UserDAO {
	
	public boolean login(String username, String password);

	public boolean createUser(String username, String password, String email);

	public int getScore();

	
}
