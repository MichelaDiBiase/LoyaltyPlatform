package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

public class Mail {

	private String recipient;
	private String text;

	public Mail (String recipient,String text){
		this.recipient=recipient;
		this.text=text;
	}

}