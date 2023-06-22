package it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class FidelityCard {

	private int id;
	private int points;
	private List<Coupon> listCoupon;

	public FidelityCard(int points) {
		this.points = points;
		this.listCoupon = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public int getPoints() {
		return points;
	}

	public List<Coupon> getListCoupon() {
		return listCoupon;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}