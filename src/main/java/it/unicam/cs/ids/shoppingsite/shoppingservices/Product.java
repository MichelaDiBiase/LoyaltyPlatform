package it.unicam.cs.ids.shoppingsite.shoppingservices;

import it.unicam.cs.ids.shoppingsite.users.Agency;

import java.util.List;

public class Product {

	private int id;
	private String name;
	private double price;
	private Agency agency;
	private int points;
	private String description;
	private List<Reviews> listReviews;

}