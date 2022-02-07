package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * To modify the product table using SQL Queries.
 * @author AswiniN
 *
 */
public class ProductsAlterationDAO {
    final String INSERT_PRODUCT = "INSERT INTO products(product_name, brand_name, price, size, user, quantity)values(?,?,?,?,?,?)";
    final String DELETE_PRODUCT = "DELETE FROM products WHERE product_name = ? and brand_name = ?";	
    final String UPDATE_PRICE = "UPDATE products SET price =? WHERE product_name =?";
    final String UPDATE_QUANTITY = "UPDATE products SET quantity =? WHERE product_name =?";
	 
    /**
    * Insert new products to the table.
    * @param products
    * @return
    */
    public boolean insertProduct(Products products) {
		
        try (Connection connection = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);) {
      	  
	    preparedStatement.setString(1, products.getProductName());
            preparedStatement.setString(2, products.getBrandName());
	    preparedStatement.setString(3, products.getPrice());
	    preparedStatement.setString(4, products.getSize());
	    preparedStatement.setString(5, products.getUser());
	    preparedStatement.setInt(6, products.getQuantity());

	    preparedStatement.execute();
	    return true;
        } catch (SQLException e) {
	    System.out.println("Error occured while inserting the product.");
	    return false;
	}	
    }
  
    /**
     * Deletes the product from table specified by the user.
     * @param products
     * @return
     */
    public boolean deleteProduct(Products products) {
		
	try (Connection connection = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);) {
				
	    preparedStatement.setString(1, products.getProductName());
       	    preparedStatement.setString(2, products.getBrandName());
			
       	    preparedStatement.execute();
            return true;	
	} catch (SQLException e) {
	    System.out.println("Error occured while deleting the product.");
	    return false;
	}	
    }
    
    /**
     * Updates the record of the table.
     * @param products
     * @return
     */
    public boolean updateProduct(Products products) {
		
	try (Connection connection = DatabaseConnection.getConnection();) {
		
	    if (products.getPrice() != null) {
	        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRICE);
		    
         	    preparedStatement.setString(1, products.getPrice());
		    preparedStatement.setString(2, products.getProductName());
		    return preparedStatement.execute();
	    } else {
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY);
	    
		    preparedStatement.setInt(1, products.getQuantity());
		    preparedStatement.setString(2, products.getProductName());
		    return preparedStatement.execute();
	    }
	} catch (SQLException e) {
	    System.out.println("Update failure!");
	    return false;
	}
    }
}
