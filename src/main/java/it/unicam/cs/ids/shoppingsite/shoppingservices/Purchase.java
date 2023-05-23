package it.unicam.cs.ids.shoppingsite.shoppingservices;

import it.unicam.cs.ids.shoppingsite.users.Customer;

import java.sql.Date;

public class Purchase {

	private Date date;
	private Customer customer;
	private int quantityShop;
	private ShoppingCart shoppingCart;

	/**
	 * 
	 * @param balance
	 * @param customer
	 */
	public void priceCheck(double balance, Customer customer) {
		// TODO - implement Purchase.priceCheck
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param customer
	 */
	public void sendInvoice(Customer customer) {
		// TODO - implement Purchase.sendInvoice
		throw new UnsupportedOperationException();
	}

	public void reset() {
		// TODO - implement Purchase.reset
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param customer
	 */
	public void sendPaymentOutcome(Customer customer) {
		// TODO - implement Purchase.sendPaymentOutcome
		throw new UnsupportedOperationException();
	}

	public void addPointsToFidelity() {
		// TODO - implement Purchase.addPointsToFidelity
		throw new UnsupportedOperationException();
	}

}