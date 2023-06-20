package it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram;

import java.util.ArrayList;
import java.util.List;

public class FidelityCard {

	private int id;
	private int points;
	private List<Coupon> listCoupon;

	public FidelityCard() {
		this.points = 0;
		this.listCoupon = new ArrayList<>();
	}

	public FidelityCard(int points) {
		this.points = points;
		this.listCoupon = new ArrayList<>();
	}

	public void addCoupon(Coupon coupon) {
		listCoupon.add(coupon);
	}

	public void removeCoupon(Coupon coupon) {
		for(Coupon c : listCoupon) {
			if(coupon.getCode().equals(c.getCode())) {
				listCoupon.remove(coupon);
			}
		}
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