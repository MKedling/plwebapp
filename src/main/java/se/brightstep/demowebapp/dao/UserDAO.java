package se.brightstep.demowebapp.dao;

import java.util.List;

import se.brightstep.demowebapp.dto.User;

public interface UserDAO {
	
	public boolean login(String username, String password);

	public boolean createUser(String username, String password, String email);

	public List<User> getAllUsers();
	public int getUserId(String username);

	
	//public int getScore();

	
}
