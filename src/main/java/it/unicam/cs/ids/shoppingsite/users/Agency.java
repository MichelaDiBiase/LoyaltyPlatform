package it.unicam.cs.ids.shoppingsite.users;

import it.unicam.cs.ids.shoppingsite.mailbox.Mailbox;
import it.unicam.cs.ids.shoppingsite.models.IUser;
import it.unicam.cs.ids.shoppingsite.shoppingservices.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "agencies")
public class Agency implements IUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;

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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}