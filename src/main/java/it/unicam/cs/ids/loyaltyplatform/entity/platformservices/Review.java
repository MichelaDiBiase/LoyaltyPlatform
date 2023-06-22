package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

public class Review {

	private String assessment;
	private int idCostumer,idAgency;

	public Review (String assessment){
		this.assessment=assessment;
	}

	/**
	 * 
	 * @param product
	 * @param text
	 */
	public void writeReviews(Product product, String text) {
		Review review=new Review(text);
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