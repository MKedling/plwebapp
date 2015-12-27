package se.brightstep.demowebapp.service.impl;


import java.util.ArrayList;

import se.brightstep.demowebapp.dao.ProductDAO;
import se.brightstep.demowebapp.dao.impl.TableRow;
import se.brightstep.demowebapp.service.ProductService;


public class DefaultProductService implements ProductService
{

	private ProductDAO productDAO;

	public ArrayList<TableRow> getSampleDate()
	{
		return productDAO.getSampleData();
	}

	public void setProductDAO(final ProductDAO productDAO)
	{
		this.productDAO = productDAO;
	}

	public TableRow getSampleDateFromProduct(final String id)
	{

		return productDAO.getSampleDataFromProduct(id);
	}

}
