package it.unicam.cs.ids.shoppingsite.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ShoppingSite", "root", "unicam-IDS2023");
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            System.out.println("There is a problem with the database, check out if the database works correctly.");
        }
        return connection;
    }

}
