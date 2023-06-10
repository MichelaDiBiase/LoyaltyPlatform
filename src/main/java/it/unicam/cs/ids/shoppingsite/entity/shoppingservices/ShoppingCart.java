package it.unicam.cs.ids.shoppingsite.entity.shoppingservices;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Product> listOfProduct;
	private double totalPrice;
	private double totalPoints;

	public ShoppingCart() {
		this.listOfProduct = new ArrayList<>();
		this.totalPrice = 0;
		this.totalPoints = 0;
	}

	/**
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addProductQuantity(Product product, int quantity) {
		listOfProduct.add(product);
		totalImport();
		sumPoints();
	}

	/**
	 *
	 * @param product
	 */
	public void removeProductQuantity(Product product, int quantity) {
		totalImport();
		sumPoints();
	}

	/**
	 *
	 */
	public void totalImport() {
		for(Product p : listOfProduct) {
			//totalPrice += p.getPrice();
		}
	}

	public void sumPoints() {
		for(Product p : listOfProduct) {
			//totalPoints += p.getPoints();
		};
	}

	public void printProductsList() {
		// TODO - implement ShoppingCart.printProductsList
		throw new UnsupportedOperationException();
	}

	public List<Product> getListOfProduct() {
		return listOfProduct;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public double getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setTotalPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}
}