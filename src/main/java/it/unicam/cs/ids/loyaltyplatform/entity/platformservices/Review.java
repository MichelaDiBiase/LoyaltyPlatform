package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

public class Review {

	private String assessment;
	private int idCostumer,idAgency;

	public Review (String assessmentint, int idCostumer, int idAgency){

		this.assessment=assessment;
		this.idCostumer=idCostumer;
		this.idAgency=idAgency;
	}

	/**
	 * 
	 * @param product
	 * @param text
	 */
	public void writeReviews(Product product, String text,int idCostumer, int idAgency) {

		Review review=new Review(text,idCostumer,idAgency);
	}

	public void operation() {
		// TODO - implement Reviews.operation
		throw new UnsupportedOperationException();
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