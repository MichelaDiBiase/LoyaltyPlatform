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
	private List<Review> listReviews;

	public Product(String name,double price,Agency agency,int points,String description,List<Review> listReviews){
		this.name=name;
		this.price=price;
		this.agency=agency;
		this.points=points;
		this.description=description;
		this.listReviews=listReviews;

	}

}