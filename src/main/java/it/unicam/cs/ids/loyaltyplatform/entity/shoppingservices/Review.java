package it.unicam.cs.ids.loyaltyplatform.entity.shoppingservices;

public class Review {

	private String assessment;

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

}