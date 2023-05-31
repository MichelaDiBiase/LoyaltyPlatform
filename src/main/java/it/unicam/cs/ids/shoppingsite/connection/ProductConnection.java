package it.unicam.cs.ids.shoppingsite.connection;

import java.sql.Connection;

public class ProductConnection {
    Connection connection;

    public ProductConnection() {
        try {
            connection = DBConnection.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
