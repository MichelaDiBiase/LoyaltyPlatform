package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

public class Review {

	private String assessment;
	private int idCostumer,idAgency;

	public Review (String assessmentint, int idCostumer, int idAgency){

		this.assessment=assessment;
		this.idCostumer=idCostumer;
		this.idAgency=idAgency;
	}


	public String getAssessment() {

		return assessment;
	}
	public int getIdCostumer() {

		return idCostumer;
	}
	public int getIdAgency() {

		return idAgency;
	}


}