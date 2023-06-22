package it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "premiumProgram")
public class FidelityCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private Integer idCustomer;
	@Column(nullable = false)
	private Integer idAgency;

	public FidelityCard(Integer idCustomer, Integer idAgency) {
		this.idCustomer = idCustomer;
		this.idAgency = idAgency;
	}

	public Integer getId() {
		return id;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public Integer getIdAgency() {
		return idAgency;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public void setIdAgency(Integer idAgency) {
		this.idAgency = idAgency;
	}
}