package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

import jakarta.persistence.*;

@Entity
@Table(name = "mail")
public class Mail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String text;

	private Integer idCustomer,idAgency;

	public Mail (String text, Integer idCustomer, Integer idAgency){
		this.text=text;
		this.idCustomer = idCustomer;
		this.idAgency=idAgency;
	}

	public Mail() {

	}

	public Integer getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCostumer) {
		this.idCustomer = idCostumer;
	}

	public Integer getIdAgency() {
		return idAgency;
	}

	public void setIdAgency (Integer idAgency) {
		this.idAgency = idAgency;
	}



}