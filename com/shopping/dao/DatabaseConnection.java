package com.shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * To get connection with the specified database by loading the driver.
 * @author AswiniN
 *
 */
public class DatabaseConnection {
    Connection connection;
	
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/passworddb", "root", "N@tt@r99");
    }
}
