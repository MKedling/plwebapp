package se.brightstep.demowebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import se.brightstep.demowebapp.session.UserSession;

public class SuperclassController {
	
	@Autowired
	protected UserSession userSession;
	
	

}
