package it.unicam.cs.ids.shoppingsite.shoppingservices;

import it.unicam.cs.ids.shoppingsite.users.Customer;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {

	private List<Product> listProduct;
	private double totalPrice;
	private LinkedList<Product> listQuantity;

	/**
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addProductAndQuantity(Product product, int quantity) {
		// TODO - implement ShoppingCart.addProductAndQuantity
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param customer
	 */
	public void quantityCheck(Customer customer) {
		// TODO - implement ShoppingCart.quantityCheck
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param customer
	 */
	public void totalImport(Customer customer) {
		// TODO - implement ShoppingCart.totalImport
		throw new UnsupportedOperationException();
	}

	public void printProductsList() {
		// TODO - implement ShoppingCart.printProductsList
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param product
	 */
	public void removeProduct(Product product) {
		// TODO - implement ShoppingCart.removeProduct
		throw new UnsupportedOperationException();
	}

	public void sumPoints() {
		// TODO - implement ShoppingCart.sumPoints
		throw new UnsupportedOperationException();
	}

}