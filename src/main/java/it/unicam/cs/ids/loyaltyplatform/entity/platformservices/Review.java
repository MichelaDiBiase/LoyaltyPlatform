package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@Column(nullable = false,unique = true)
	private Integer id;
	@Column(nullable = false)
	private String assessment;
	@Column(nullable = false)
	private Integer idCostumer,idAgency;

	public Review (String assessment, Integer idCostumer, Integer idAgency){

		this.assessment=assessment;
		this.idCostumer=idCostumer;
		this.idAgency=idAgency;
	}

	public Review() {

	}


	public String getAssessment() {

		return assessment;
	}
	public Integer getIdCostumer() {

		return idCostumer;
	}
	public Integer getIdAgency() {

		return idAgency;
	}

	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}

	public void setIdCostumer(Integer idCostumer) {
		this.idCostumer = idCostumer;
	}

	public void setIdAgency(Integer idAgency) {
		this.idAgency = idAgency;
	}
}