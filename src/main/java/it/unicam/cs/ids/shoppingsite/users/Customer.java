package it.unicam.cs.ids.shoppingsite.users;

import it.unicam.cs.ids.shoppingsite.mailbox.Mailbox;
import it.unicam.cs.ids.shoppingsite.premiumprogram.FidelityCard;
import it.unicam.cs.ids.shoppingsite.shoppingservices.Product;

public abstract class Customer {

	private String name;
	private String surname;
	private String email;
	private FidelityCard fidelityCard;
	private Mailbox MailBox;
	private String gender;

	public void editProfile() {
		// TODO - implement Customer.editProfile
		throw new UnsupportedOperationException();
	}

	public void buyProduct() {
		// TODO - implement Customer.buyProduct
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addToShoppingCart(Product product, int quantity) {
		// TODO - implement Customer.addToShoppingCart
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param product
	 * @param quantity
	 */
	public void removeFromShoppingCart(Product product, int quantity) {
		// TODO - implement Customer.removeFromShoppingCart
		throw new UnsupportedOperationException();
	}

}