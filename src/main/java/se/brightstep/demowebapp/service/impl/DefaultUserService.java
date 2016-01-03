package se.brightstep.demowebapp.service.impl;


import se.brightstep.demowebapp.dao.UserDAO;
import se.brightstep.demowebapp.service.UserService;

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

	public int getScore() {
		
		return userDAO.getScore();
	}


}
