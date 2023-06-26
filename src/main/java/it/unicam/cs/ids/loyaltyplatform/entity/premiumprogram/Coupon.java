package it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "coupons")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;
	private Integer points;
	@Column(nullable = false)
	private Integer discount;
	private Integer idCustomer;
	@Column(nullable = false)
	private Integer idAgency;

	public Coupon(Integer code, Integer points, Integer discount, Integer idAgency) {
		this.code = code;
		this.points = points;
		this.discount = discount;
		this.idAgency = idAgency;
	}

	public Coupon(Integer code, Integer discount, Integer idAgency) {
		this.code = code;
		this.discount = discount;
		this.idAgency = idAgency;
	}

	public Integer getCode() {
		return code;
	}

	public Integer getPoints() {
		return points;
	}

	public Integer getDiscount() {
		return discount;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public Integer getIdAgency() {
		return idAgency;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public void setIdAgency(Integer idAgency) {
		this.idAgency = idAgency;
	}
}