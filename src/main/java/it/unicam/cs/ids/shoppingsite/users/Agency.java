package it.unicam.cs.ids.shoppingsite.users;

import it.unicam.cs.ids.shoppingsite.mailbox.Mailbox;
import it.unicam.cs.ids.shoppingsite.models.IAgency;
import it.unicam.cs.ids.shoppingsite.shoppingservices.Product;

public class Agency implements IAgency {

	private String name;
	private String email;
	private Mailbox mailbox;

	public void editProfile() {
		// TODO - implement Agency.editProfile
		throw new UnsupportedOperationException();
	}

	public void generateProduct(String name, double price, int points, String description) {
		// TODO - implement Agency.generateProduct
		throw new UnsupportedOperationException();
	}

	public void addProductQuantityToCatalog(Product product, int quantity) {
		// TODO - implement Agency.addProductQuantityToCatalog
		throw new UnsupportedOperationException();
	}

	public void removeProductQuantityFromCatalog(Product product, int quantity) {
		// TODO - implement Agency.removeProductQuantityFromCatalog
		throw new UnsupportedOperationException();
	}



}