package app.service;

import java.util.List;

import app.dto.User;

public interface UserService {
	
	public boolean login(String username, String password);

	public boolean createUser(String username, String password, String email);
	
	public List<User> getAllUsers();
	public User getUser(String username);
	public User getUser(int userId);
	public int getUserId(String username);
	

	
}
