package it.unicam.cs.ids.loyaltyplatform.entity.users;

import it.unicam.cs.ids.loyaltyplatform.entity.loyaltyplan.LoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.entity.registration.RegistrationLoyaltyPlan;
import it.unicam.cs.ids.loyaltyplatform.models.IUser;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "agencies")
public class Agency implements IUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true,
			nullable = false)
	private String name;
	@Column(unique = true,
			nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLoyaltyPlan")
	private List<LoyaltyPlan> loyaltyPlans;

	public Agency(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public void addLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
		loyaltyPlans.add(loyaltyPlan);
	}

	public void removeLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
		for(LoyaltyPlan lp : loyaltyPlans) {
			if(lp.getId().equals(loyaltyPlan.getId())) {
				loyaltyPlans.remove(loyaltyPlan);
			}
		}
	}

	public boolean checkLoyaltyPlan(LoyaltyPlan loyaltyPlan) {
		for(LoyaltyPlan r : loyaltyPlans) {
			if(r.getId().equals(loyaltyPlan.getId())) {
				return true;
			}
		}
		return false;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public List<LoyaltyPlan> getLoyaltyPlans() {
		return loyaltyPlans;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	public void setLoyaltyPlans(List<LoyaltyPlan> loyaltyPlans) {
		this.loyaltyPlans = loyaltyPlans;
	}
}