package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String text;
	@Column(nullable = false)
	private Integer idCustomer,idAgency;

	public Review (String text, Integer idCustomer, Integer idAgency){

		this.text =text;
		this.idCustomer=idCustomer;
		this.idAgency=idAgency;
	}

	public Review() {

	}

	public Integer getId() {
		return id;
	}

	public String getText() {

		return text;
	}
	public Integer getIdCustomer() {

		return idCustomer;
	}
	public Integer getIdAgency() {

		return idAgency;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setIdCostumer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public void setIdAgency(Integer idAgency) {
		this.idAgency = idAgency;
	}
}