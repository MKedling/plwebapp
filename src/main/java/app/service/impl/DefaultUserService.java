package app.service.impl;


import java.util.List;

import app.dao.UserDAO;
import app.dto.User;
import app.service.UserService;

public class DefaultUserService implements UserService{

	private UserDAO userDAO;
	
	public boolean login(String username, String password) {
		return userDAO.login(username, password);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean createUser(String username, String password, String email) {
		
		return userDAO.createUser(username, password, email);
	}


	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public int getUserId(String username) {
		
		return userDAO.getUserId(username);
	}

	@Override
	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	@Override
	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}


}
