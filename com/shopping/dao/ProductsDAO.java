package com.shopping.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * It stores and displays the data in list format.
 * @author AswiniN
 *
 */
public class ProductsDAO {
	final String SELECT = "SELECT * FROM products";
    /**
     * Select all data from products table.
     * @return
     */
	public List<Products> selectAllProducts() {  
	   final List<Products> productsList = new ArrayList<Products>();
		
	    try (Connection connection = DatabaseConnection.getConnection(); 
				Statement statement = connection.createStatement();
			    ResultSet productsResultSet = statement.executeQuery(SELECT);) {
	
			while(productsResultSet.next()) {
				Products products = new Products();
				
				products.setProductName(productsResultSet.getString(2));
				products.setBrandName(productsResultSet.getString(3));
				products.setPrice(productsResultSet.getString(4));
				products.setSize(productsResultSet.getString(5));
				products.setUser(productsResultSet.getString(6));					
				products.setQuantity(productsResultSet.getInt(7));
				
				productsList.add(products);
			}
		    return productsList;
        } catch (SQLException e) {
		    System.out.println("SQL Error occured");
	    }
		return productsList;
	}

}
