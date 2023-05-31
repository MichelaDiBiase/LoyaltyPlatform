package it.unicam.cs.ids.shoppingsite.connection;

import java.sql.Connection;
public class CatalogConnection {
    Connection connection;

    public CatalogConnection() {
        try {
            connection = DBConnection.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


