package se.brightstep.demowebapp.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import se.brightstep.demowebapp.dao.ProductDAO;


public class DefaultProductDAO implements ProductDAO
{

	private JdbcTemplate jdbcTemplate;

	public ArrayList<TableRow> getSampleData()
	{


		final List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from products");

		final ArrayList<TableRow> resultList = new ArrayList<TableRow>();

		TableRow temp;

		for (final Map row : rows)
		{
			temp = new TableRow();
			temp.setId((Integer) row.get("id"));
			temp.setName((String) row.get("p_name"));
			temp.setDescription((String) row.get("description"));
			temp.setImage((String) row.get("p_image"));
			temp.setPrice((BigDecimal) row.get("price"));
			resultList.add(temp);
		}



		return resultList;
		//return jdbcTemplate.queryForObject("select p_image from products where id=1", String.class);
	}

	public void setDataSource(final DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public TableRow getSampleDataFromProduct(final String id)
	{

		final List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from products where id='" + id + "'");

		final TableRow temp = new TableRow();

		for (final Map row : rows)
		{
			temp.setId((Integer) row.get("id"));
			temp.setName((String) row.get("p_name"));
			temp.setDescription((String) row.get("description"));
			temp.setImage((String) row.get("p_image"));
			temp.setPrice((BigDecimal) row.get("price"));
		}

		return temp;
	}

}
