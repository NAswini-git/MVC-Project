package com.shopping.view;

import com.shopping.dao.User;

/**
 * The class validates the input given by the user.
 * @author AswiniN
 *
 */
public class ViewValidation {
    final static User user = new User();
    /**
     * It validates EmailId.
     * @param emailId
     * @return
     */
    public static String validateEmailId(String emailId) {
			
	if (emailId != null && emailId.matches("^[A-Za-z0-9]{4,}+@[a-z]+.[a-z]{2,3}$")) { 
	    return emailId;
	} else {
	    System.out.println("Invalid Email Id.");
	    LoginPortal.getEmailId();
	    return null;
	}	
    }
	
    /**
     * It validates Password.
     * @param password
     * @return
     */
    public static String validatePassword(String password) {
	
	if (password.matches("^(.+)(?=.*[@#$%^&-+=()])(?=\\S+$).{6,10}$"))	{
	    System.out.println("Valid Password.");	
	} else {
	    System.out.println("Invalid");
	    password = LoginPortal.getPassword();
	}
	return password;
    }
}
