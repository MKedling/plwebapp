package se.brightstep.demowebapp.dao;

import java.util.ArrayList;

import se.brightstep.demowebapp.dao.impl.TableRow;


public interface ProductDAO
{
	ArrayList<TableRow> getSampleData();

	TableRow getSampleDataFromProduct(String id);
}
