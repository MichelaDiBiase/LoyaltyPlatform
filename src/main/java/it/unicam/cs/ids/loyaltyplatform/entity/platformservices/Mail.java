package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

public class Mail {

	private String recipient;
	private String text;

	private int idCostumer,idAgency;

	public Mail (String recipient, String text, int idCostumer, int idAgency){
		this.recipient=recipient;
		this.text=text;
		this.idCostumer=idCostumer;
		this.idAgency=idAgency;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getIdCostumer() {
		return idCostumer;
	}

	public void setIdCostumer(int idCostumer) {
		this.idCostumer = idCostumer;
	}

	public int getIdAgency() {
		return idAgency;
	}

	public void setIdAgency(int idAgency) {
		this.idAgency = idAgency;
	}



}