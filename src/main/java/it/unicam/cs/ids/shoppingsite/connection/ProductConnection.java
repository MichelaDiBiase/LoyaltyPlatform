package it.unicam.cs.ids.shoppingsite.connection;

import it.unicam.cs.ids.shoppingsite.shoppingservices.Review;
import it.unicam.cs.ids.shoppingsite.users.Agency;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductConnection {
    @Id
    private Integer id;
    private String name;
    private Double price;
    private Agency agency;
    private Integer pints;
    private String decription;
    private Review review;

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

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Integer getPints() {
        return pints;
    }

    public void setPints(Integer pints) {
        this.pints = pints;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
