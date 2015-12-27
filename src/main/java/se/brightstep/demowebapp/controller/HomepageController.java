package se.brightstep.demowebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.service.ExampleService;

@Controller
@RequestMapping(value = "/")
public class HomepageController {
	
	@Autowired
	private ExampleService exampleService;

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public ModelAndView handleRequest()
	{
		final ModelAndView mav = new ModelAndView("homeview");//return example.jsp view
	
		
		return mav;
	}

}
