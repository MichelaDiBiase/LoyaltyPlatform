package it.unicam.cs.ids.shoppingsite.purchase;

import it.unicam.cs.ids.shoppingsite.entity.shoppingservices.Product;

import java.util.Date;
import java.util.List;

public class Invoice {

    public Date date;
    public List<Product> listOfProducts;
    public double totalPrice;

    public Invoice(Date date, List<Product> listOfProducts, double totalPrice) {
        this.date = date;
        this.listOfProducts = listOfProducts;
        this.totalPrice = totalPrice;
    }


    public void addProduct(Product product) {
        listOfProducts.add(product);
    }

    public void removeProduct(Product product) {
        listOfProducts.remove(product);
    }

    public void addListOfProduct(List<Product> listOfProducts) {
        for(Product p : listOfProducts) {
            if(!this.listOfProducts.contains(p)) {
                this.listOfProducts.add(p);
            }
        }
    }

    public void removeListOfProduct(List<Product> listOfProducts) {
        for(Product p : listOfProducts) {
            this.listOfProducts.remove(p);
        }
    }

    public Date getDate() {
        return date;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
