package it.unicam.cs.ids.shoppingsite.shoppingservices;

import java.util.List;

public class Catalog {

	private List<Product> listProduct;
	private List<Review> listReviews;

	/**
	 * 
	 * @param product
	 */
	public void addProductQuantity(Product product, int quantity) {
		// TODO - implement Catalog.addProduct
		listProduct.add(product);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param product
	 */
	public void removeProductQuantity(Product product, int quantity) {
		// TODO - implement Catalog.removeProduct
		listProduct.remove(product);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param review
	 */
	public void addReviews(Review review) {
		// TODO - implement Catalog.addReviews
		listReviews.add(review);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nameProduct
	 */
	public Product searchProduct(String nameProduct) {
		// TODO - implement Catalog.searchProduct
		listProduct.lastIndexOf(nameProduct);
		throw new UnsupportedOperationException();
	}

	public void printProductsList() {
		// TODO - implement Catalog.printProductsList
		throw new UnsupportedOperationException();
	}

}