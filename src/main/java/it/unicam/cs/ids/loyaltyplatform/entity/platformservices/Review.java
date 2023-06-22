package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

public class Review {

	private String assessment;
	private Integer idCostumer,idAgency;

	public Review (String assessment, Integer idCostumer, Integer idAgency){

		this.assessment=assessment;
		this.idCostumer=idCostumer;
		this.idAgency=idAgency;
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