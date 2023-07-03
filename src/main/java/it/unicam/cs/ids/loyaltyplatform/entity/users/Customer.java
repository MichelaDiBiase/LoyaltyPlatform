package it.unicam.cs.ids.loyaltyplatform.entity.users;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.entity.premiumprogram.FidelityCard;
import it.unicam.cs.ids.loyaltyplatform.models.IUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer implements IUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false)
	private Boolean gender;
	@Column(unique = true,
			nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	private Integer points;
	private Boolean premium;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLoyaltyPlan")
	private List<LoyaltyPlan> loyaltyPlans;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idFidelityCard")
	private FidelityCard fidelityCard;

	public Customer(String name, String surname, String email, String password, Boolean gender) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}

	public void addLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
		loyaltyPlans.add(loyaltyPlan);
		premium = true;
	}

	public void removeLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
		loyaltyPlans.remove(loyaltyPlan);
		if(loyaltyPlans.isEmpty()) {
			premium = false;
		}
	}

	public boolean checkLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
		for(LoyaltyPlan lp : loyaltyPlans) {
			if(lp.getId().equals(loyaltyPlan.getId())) {
				return true;
			}
		}
		return false;
	}

	public void sumPoints(Integer points) {
		this.points += points;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public Integer getPoints() {
		return points;
	}

	public Boolean getGender() {
		return gender;
	}

	public Boolean getPremium() {
		return premium;
	}

	public List<LoyaltyPlan> getLoyaltyPlans() {
		return loyaltyPlans;
	}

	public FidelityCard getFidelityCard() {
		return fidelityCard;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	public void setLoyaltyPlans(List<LoyaltyPlan> loyaltyPlans) {
		this.loyaltyPlans = loyaltyPlans;
	}

	public void setFidelityCard(FidelityCard fidelityCard) {
		this.fidelityCard = fidelityCard;
	}
}