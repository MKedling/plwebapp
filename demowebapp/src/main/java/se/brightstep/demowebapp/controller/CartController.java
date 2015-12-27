package se.brightstep.demowebapp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import se.brightstep.demowebapp.dao.impl.TableRow;
import se.brightstep.demowebapp.session.ShoppingCart;


@Controller
@RequestMapping(value = "/")
@Scope(value = "session")
public class CartController

{

	@Autowired
	private ShoppingCart cart;

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView handleRequestCart()
	{
		final ModelAndView mav = new ModelAndView("cart");

		final ArrayList<TableRow> cartList = cart.getShoppingCart();
		mav.addObject("cartList", cartList);


		return mav;
	}

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public ModelAndView handleRequestAdd(@RequestParam("p_name") final String p_name, @RequestParam("id") final Integer id,
			@RequestParam("price") final BigDecimal price)
	{
		final ModelAndView mav = new ModelAndView("cart");

		final TableRow temp = new TableRow();
		temp.setName(p_name);
		temp.setId(id);
		temp.setPrice(price);

		cart.addToCart(temp);

		final ArrayList<TableRow> cartList = cart.getShoppingCart();
		mav.addObject("cartList", cartList);

		BigDecimal totalPrice = new BigDecimal(0);
		for (final TableRow r : cartList)
		{
			totalPrice = totalPrice.add(r.getPrice());
		}
		mav.addObject("totalPrice", totalPrice);


		return mav;
	}



}
