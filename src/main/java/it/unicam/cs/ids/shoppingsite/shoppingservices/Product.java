package it.unicam.cs.ids.shoppingsite.shoppingservices;

import it.unicam.cs.ids.shoppingsite.users.Agency;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity

public class Product {
    @Id
    private Integer id;
    private String name;
    private Double price;
    private Integer points;
    private String description;

    public Product() {

    }

    public Product(String name, double price, Agency agency, int points, String description, List<Review> listReviews) {
        this.name = name;
        this.price = price;
        this.points = points;
        this.description = description;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}