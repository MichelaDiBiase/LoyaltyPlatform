package it.unicam.cs.ids.loyaltyplatform.entity.users;

import it.unicam.cs.ids.loyaltyplatform.entity.platformservices.FidelityCard;
import it.unicam.cs.ids.loyaltyplatform.entity.registration.RegistrationLoyaltyPlan;
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
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLoyaltyPlan")
	private List<RegistrationLoyaltyPlan> registrations;
	private Boolean premium;
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

	public void addRegistration(RegistrationLoyaltyPlan registration) {
		registrations.add(registration);
		premium = true;
	}

	public void removeRegistration(RegistrationLoyaltyPlan registration) {
		registrations.remove(registration);
		if(registrations.isEmpty()) {
			premium = false;
		}
	}

	public boolean checkRegistration(RegistrationLoyaltyPlan registration) {
		for(RegistrationLoyaltyPlan r : registrations) {
			if(r.getId().equals(registration.getId())) {
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

	public List<RegistrationLoyaltyPlan> getRegistrations() {
		return registrations;
	}

	public Boolean getPremium() {
		return premium;
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


	public void setRegistrations(List<RegistrationLoyaltyPlan> registrations) {
		this.registrations = registrations;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	public void setFidelityCard(FidelityCard fidelityCard) {
		this.fidelityCard = fidelityCard;
	}
}