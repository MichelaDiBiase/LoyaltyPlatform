package it.unicam.cs.ids.loyaltyplatform.entity.users;

import it.unicam.cs.ids.loyaltyplatform.models.IUser;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
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
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private Boolean gender;

	public Customer(String name, String surname, String email, Boolean gender) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.gender = gender;
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

	public Boolean getGender() {
		return gender;
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

	public void setGender(Boolean gender) {
		this.gender = gender;
	}
}