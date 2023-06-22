package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

public class Mail {

	private String recipient;
	private String text;

	private Integer idCostumer,idAgency;

	public Mail (String recipient, String text, Integer idCostumer, Integer idAgency){
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

	public Integer getIdCostumer() {
		return idCostumer;
	}

	public void setIdCostumer(Integer idCostumer) {
		this.idCostumer = idCostumer;
	}

	public Integer getIdAgency() {
		return idAgency;
	}

	public void setIdAgency (Integer idAgency) {
		this.idAgency = idAgency;
	}



}