package it.unicam.cs.ids.shoppingsite.models;

import it.unicam.cs.ids.shoppingsite.shoppingservices.Product;

public interface ICustomer {

    /**
     *
     * @param name
     * @param surname
     * @param email
     * @param gender
     */
    void editProfile(String name, String surname, String email, String gender);

    /**
     *
     */
    void buyProduct();

    /**
     *
     * @param product
     * @param quantity
     */
    void addToShoppingCart(Product product, int quantity);

    /**
     *
     * @param product
     * @param quantity
     */
    void removeFromShoppingCart(Product product, int quantity);

    /**
     *
     * @param role
     */
    void upgradeRole(RolesType role);
}
