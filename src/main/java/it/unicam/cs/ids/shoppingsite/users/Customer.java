package it.unicam.cs.ids.shoppingsite.users;

import it.unicam.cs.ids.shoppingsite.mailbox.Mailbox;
import it.unicam.cs.ids.shoppingsite.models.ICustomer;
import it.unicam.cs.ids.shoppingsite.models.RolesType;
import it.unicam.cs.ids.shoppingsite.premiumprogram.FidelityCard;
import it.unicam.cs.ids.shoppingsite.shoppingservices.Catalog;
import it.unicam.cs.ids.shoppingsite.shoppingservices.Product;
import it.unicam.cs.ids.shoppingsite.shoppingservices.ShoppingCart;

import javax.management.relation.Role;

public class Customer implements ICustomer {

	private String name;
	private String surname;
	private String email;
	private String gender;
	private ShoppingCart shoppingCart;
	private Mailbox mailBox;
	private RolesType role;

	public Customer(String name, String surname, String email, String gender) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.gender = gender;
		this.shoppingCart = new ShoppingCart();
		this.mailBox = new Mailbox();
		this.role = RolesType.basic;
	}

	public void editProfile(String name, String surname, String email, String gender) {
		setName(name);
		setSurname(surname);
		setEmail(email);
		setGender(gender);
	}

	public void buyProduct() {
		// TODO - implement Customer.buyProduct
		throw new UnsupportedOperationException();
	}

	public void addToShoppingCart(Product product, int quantity) {
		shoppingCart.addProductQuantity(product, quantity);
	}

	public void removeFromShoppingCart(Product product, int quantity) {
		shoppingCart.removeProductQuantity(product, quantity);
	}

	public void upgradeRole(RolesType role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public Mailbox getMailBox() {
		return mailBox;
	}

	public RolesType getRole() {
		return role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}