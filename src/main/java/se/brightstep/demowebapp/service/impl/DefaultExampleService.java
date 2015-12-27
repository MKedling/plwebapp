package se.brightstep.demowebapp.service.impl;

import se.brightstep.demowebapp.dao.ExampleDAO;
import se.brightstep.demowebapp.service.ExampleService;

public class DefaultExampleService implements ExampleService{

	private ExampleDAO exampleDAO;
	
	public String getSampleDate() {
		return exampleDAO.getSampleData();
	}

	public void setExampleDAO(ExampleDAO exampleDAO) {
		this.exampleDAO = exampleDAO;
	}

}
