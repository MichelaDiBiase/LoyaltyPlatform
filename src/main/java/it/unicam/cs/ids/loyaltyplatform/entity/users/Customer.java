package it.unicam.cs.ids.loyaltyplatform.entity.users;

import it.unicam.cs.ids.loyaltyplatform.models.IUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

	public Customer(String name, String surname, String email, String password, Boolean gender) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.email = email;
		this.password = password;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
}