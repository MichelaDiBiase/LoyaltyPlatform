package it.unicam.cs.ids.shoppingsite.shoppingservices;

import java.util.List;

public class Catalog {

    private List<Product> listProduct;
    private List<Review> listReviews;

    public Catalog(List<Product> listProduct,List<Review> listReviews){
        this.listProduct=listProduct;
        this.listReviews=listReviews;
    }

    /**
     * @param product
     */
    public void addProductQuantity(Product product, int quantity) {
        listProduct.add(product);

    }

    /**
     * @param product
     */
    public void removeProductQuantity(Product product, int quantity) {
        listProduct.remove(product);
    }

    /**
     * @param review
     */
    public void addReviews(Review review) {//TODO add ptoduct?
        listReviews.add(review);
    }

    /**
     * @param nameProduct
     */
    public Product searchProduct(String nameProduct) {

        for (Product product : listProduct){
            if(nameProduct.equals(product.getName())){
                return product;
            }

        }
        return null;
    }

    public void printProductsList() {
        for (Product product : listProduct) {
            System.out.println(product);
        }
    }

}