package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "fidelityCard")
public class FidelityCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idCustomer;

	public FidelityCard(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Integer getId() {
		return id;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

}