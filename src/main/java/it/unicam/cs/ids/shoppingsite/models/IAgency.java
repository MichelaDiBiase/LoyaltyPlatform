package it.unicam.cs.ids.shoppingsite.models;

import it.unicam.cs.ids.shoppingsite.shoppingservices.Product;

public interface IAgency {

    /**
     *
     */
    void editProfile();

    /**
     *
     * @param name
     * @param price
     * @param points
     * @param description
     */
    void generateProduct(String name, double price, int points, String description);

    /**
     *
     * @param product
     * @param quantity
     */
    void addProductQuantityToCatalog(Product product, int quantity);

    /**
     *
     * @param product
     * @param quantity
     */
    void removeProductQuantityFromCatalog(Product product, int quantity);

}
