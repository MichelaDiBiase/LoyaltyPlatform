package it.unicam.cs.ids.shoppingsite.purchase;

import it.unicam.cs.ids.shoppingsite.shoppingservices.ShoppingCart;
import it.unicam.cs.ids.shoppingsite.users.Customer;

import java.sql.Date;

public class Purchase {

	private Date date;
	private int quantityShop;
	private final ShoppingCart shoppingCart;

	public Purchase(Date date, int quantityShop, ShoppingCart shoppingCart) {
		this.date = date;
		this.quantityShop = quantityShop;
		this.shoppingCart = shoppingCart;
	}

	/**
	 *
	 */
	public void sendInvoice() {
		Invoice invoice = new Invoice(date, shoppingCart.getListProduct(), shoppingCart.getTotalPrice());
		//TODO Mailbox or Mail methods needed
	}

	public void addPointsToFidelity() {
		//TODO
	}

	public Date getDate() {
		return date;
	}

	public int getQuantityShop() {
		return quantityShop;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setQuantityShop(int quantityShop) {
		this.quantityShop = quantityShop;
	}
}