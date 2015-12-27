package se.brightstep.demowebapp.service;

import java.util.ArrayList;

import se.brightstep.demowebapp.dao.impl.TableRow;


public interface ProductService
{
	ArrayList<TableRow> getSampleDate();

	TableRow getSampleDateFromProduct(String id);

}
