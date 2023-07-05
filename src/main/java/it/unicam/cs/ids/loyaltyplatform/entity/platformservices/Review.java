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
	private Integer idCostumer,idAgency;

	public Review (String text, Integer idCostumer, Integer idAgency){

		this.text =text;
		this.idCostumer=idCostumer;
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
	public Integer getIdCostumer() {

		return idCostumer;
	}
	public Integer getIdAgency() {

		return idAgency;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setIdCostumer(Integer idCostumer) {
		this.idCostumer = idCostumer;
	}

	public void setIdAgency(Integer idAgency) {
		this.idAgency = idAgency;
	}
}