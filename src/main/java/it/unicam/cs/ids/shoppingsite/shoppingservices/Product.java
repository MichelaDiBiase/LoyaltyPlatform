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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Review> getListReviews() {
		return listReviews;
	}

	public void setListReviews(List<Review> listReviews) {
		this.listReviews = listReviews;
	}
}