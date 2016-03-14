package app.dto;

import java.math.BigDecimal;


public class TableRow
{

	private Integer id;
	private String name;

	private String description;
	private String image;
	private BigDecimal price;



	public TableRow()
	{
		// TODO Auto-generated constructor stub
	}

	public Integer getId()
	{
		return id;
	}


	public void setId(final Integer id)
	{
		this.id = id;
	}


	public String getName()
	{
		return name;
	}


	public void setName(final String name)
	{
		this.name = name;
	}


	public String getDescription()
	{
		return description;
	}


	public void setDescription(final String description)
	{
		this.description = description;
	}


	public String getImage()
	{
		return image;
	}


	public void setImage(final String image)
	{
		this.image = image;
	}


	public BigDecimal getPrice()
	{
		return price;
	}


	public void setPrice(final BigDecimal price)
	{
		this.price = price;
	}



}
