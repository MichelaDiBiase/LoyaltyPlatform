package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mail")
public class Mail {

	@Id
	@Column(nullable = false,unique = true)
	private Integer id;
	@Column(nullable = false)
	private String recipient;
	@Column(nullable = false)
	private String text;

	private Integer idCostumer,idAgency;

	public Mail (String recipient, String text, Integer idCostumer, Integer idAgency){
		this.recipient=recipient;
		this.text=text;
		this.idCostumer=idCostumer;
		this.idAgency=idAgency;
	}

	public Mail() {

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