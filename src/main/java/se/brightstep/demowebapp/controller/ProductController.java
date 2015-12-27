package se.brightstep.demowebapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.dao.impl.TableRow;
import se.brightstep.demowebapp.service.ProductService;


@Controller
@RequestMapping(value = "/")
public class ProductController
{

	@Autowired
	private ProductService productService;



	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView handleRequest()
	{
		final ModelAndView mav = new ModelAndView("productview");


		final ArrayList<TableRow> res = productService.getSampleDate();

		mav.addObject("products", res);


		return mav;
	}


	@RequestMapping(value = "/product/details", method = RequestMethod.GET)
	public ModelAndView handleRequestDetails(@RequestParam(value = "q") final String query)
	{
		final ModelAndView mav = new ModelAndView("details");

		mav.addObject("query", query);

		final TableRow res = productService.getSampleDateFromProduct(query);

		mav.addObject("products", res);


		return mav;
	}








}
