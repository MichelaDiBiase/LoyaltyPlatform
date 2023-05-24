package it.unicam.cs.ids.shoppingsite.users;

import it.unicam.cs.ids.shoppingsite.premiumprogram.FidelityCard;

public class CustomerPremium extends Customer {

	private FidelityCard fidelityCard;

	public CustomerPremium(String name, String surname, String email, String gender) {
		super(name, surname, email, gender);
		this.fidelityCard = new FidelityCard();
	}

	public void useCoupon() {
		// TODO - implement CustomerPremium.useCoupon
		throw new UnsupportedOperationException();
	}

}