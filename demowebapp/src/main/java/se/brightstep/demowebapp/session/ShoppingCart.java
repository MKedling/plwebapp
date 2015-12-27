package se.brightstep.demowebapp.session;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import se.brightstep.demowebapp.dao.impl.TableRow;


@Component
@Scope(value = "session")
public class ShoppingCart
{

	private final ArrayList<TableRow> shoppingCartList = new ArrayList<TableRow>();


	public void addToCart(final TableRow item)
	{
		shoppingCartList.add(item);
	}

	public ArrayList<TableRow> getShoppingCart()
	{
		return shoppingCartList;
	}




}
