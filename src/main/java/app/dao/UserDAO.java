package app.dao;

import java.util.List;

import app.dto.User;

public interface UserDAO {
	
	public boolean login(String username, String password);

	public boolean createUser(String username, String password, String email);

	public List<User> getAllUsers();
	public int getUserId(String username);

	public User getUser(String username);
	public User getUser(int userId);
	
	public void setSqlTimeZone(String timeZone);

	
}
