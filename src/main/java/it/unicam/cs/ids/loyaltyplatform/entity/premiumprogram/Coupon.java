package it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram;

public class Coupon {

	private String code;
	private int points;
	private int discount;

	public Coupon(int discount) {
		this.discount = discount;
	}
	public Coupon(int points, int discount) {
		this.points = points;
		this.discount = discount;
	}

	public Coupon(String code, int points, int discount) {
		this.code = code;
		this.points = points;
		this.discount = discount;
	}

	public String getCode() {
		return code;
	}

	public int getPoints() {
		return points;
	}

	public int getDiscount() {
		return discount;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}