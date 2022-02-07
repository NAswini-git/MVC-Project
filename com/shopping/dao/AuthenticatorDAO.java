package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * To retrieve data from table using SQL Queries to authenticate user.
 * @author AswiniN
 *
 */
public class AuthenticatorDAO {
	
    /**
    * It gets data with the help of EmailId.
    * @param emailId
    * @return
    */
    public User getUserEmailId(String emailId) {
	final User user = new User();
	final String SELECT = "SELECT * FROM user WHERE email_id='" + emailId + "'";
		
	try (Connection connection = DatabaseConnection.getConnection(); 
		Statement statement = connection.createStatement(); 
		ResultSet userResultSet = statement.executeQuery(SELECT);) {
			
	    while (userResultSet.next()) {
		user.setEmailId(userResultSet.getString(2));
		user.setPassword(userResultSet.getString(3));
		user.setUserType(userResultSet.getString(4));
	    }
	    return user;
	} catch (SQLException e) {
	    System.out.println("SQL exception occured in user");
	}
	    return user;
	}
	
    /**
    * Inserts user .
    * @param emailId
    * @param password
    * @param string
    */
    public void insertUserData(User user, String typeOfUser) {
	final String INSERT_ID_DETAILS = "INSERT INTO user (email_id, password, type_of_user)VALUES(?,?,?)";
		
	try (Connection connection = DatabaseConnection.getConnection(); 
	        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ID_DETAILS);) {
				  
	    preparedStatement.setString(1, user.getEmailId());
       	    preparedStatement.setString(2, user.getPassword());
	    preparedStatement.setString(3, typeOfUser);

	    preparedStatement.executeUpdate();
	} catch (SQLException e) {
	    System.out.println("Insertion error occured..");
	}	
    }
}
