package com.shopping.view;

import java.util.Scanner;

import com.shopping.controller.AuthenticationController;
import com.shopping.dao.User;

/**
 * User registration and login.
 * @author AswiniN
 *
 */
public class LoginPortal {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final AuthenticationController authenticationController = new AuthenticationController();
    final static User user = new User();
	
    /**
     * Register or Login choice.
     */
    public static void registerPortal() {	
	System.out.println("1. SignUp  2. SignIn");
		
	try {
	    user.setPreferredChoice(Integer.parseInt(SCANNER.next())); 
		  
            if (user.getPreferredChoice() == 1 || user.getPreferredChoice() == 2) {
            	LoginPortal.preferUserType(user);
	    } else {
		System.out.println("Invalid choice. Give a valid input.");
		LoginPortal.registerPortal();
	    }	
	} catch (NumberFormatException e) {
	    System.out.println("You should enter a valid input!");
	    LoginPortal.registerPortal();
	}
    }
	
    /**
     * Get the type of user either admin or user. 
     * @param user
     */
    private static void preferUserType(User user) {
	System.out.println("1. Admin  2. User");
		
	try {
	    user.setTypeOfUser(Integer.parseInt(SCANNER.next()));
			
       	    if (user.getTypeOfUser() == 1 || user.getTypeOfUser() == 2) {
		LoginPortal.signUpSignIn(user);	
	    } else {
		System.out.println("Invalid choice. Give a valid input.");
		LoginPortal.preferUserType(user);
	    }
	} catch (NumberFormatException e) {
	    System.out.println("You should enter a valid input!");
	    LoginPortal.preferUserType(user);		
	}
    } 
	
    /**
     * Routes the user based on the selected choice.
     * @param user
     */
    public static void signUpSignIn(User user) {
	user.setEmailId(getEmailId());
		
	final boolean isEmailValid = authenticationController.validateEmailId(user.getEmailId());
	checkEmail(isEmailValid, user);
	user.setPassword(LoginPortal.getPassword());
		
	if (user.getPreferredChoice() ==1) {
			
	    if (user.getTypeOfUser() == 1) {
	        LoginPortal.checkKey(user);		
	    }
	    authenticationController.insertData(user);
	}  else {
	    if (user.getPreferredChoice() == 2) {
		checkPassword(user);			
	    }
	}
    }
	
    /**
     * Get EmailId.
     * @return
     */
    public static String getEmailId() {
	System.out.println("Enter EmailId:");
	return ViewValidation.validateEmailId(SCANNER.next());		 
    }
	
    /**
     * Get Password.
     * @return
     */
    public static String getPassword() {
	System.out.println("Enter Password:");
	return ViewValidation.validatePassword(LoginPortal.SCANNER.next());
    }
	
    /**
     * Gets authenticator key if the user is admin.
     *
     * @param user
     * @return
     */
    private static void checkKey(final User user) {
	System.out.println("Enter Key:");
		
	if ("admin".equals(LoginPortal.SCANNER.next())) {
	     System.out.println("Data eligible for insertion.");
	} else {
       	     System.out.println("Invalid key.");
	     LoginPortal.checkKey(user);
	}		
    }
	
    /**
     * Validates the mail by routing input to validation.
     * @param emailStatus
     * @param user
     */
    public static void checkEmail(final boolean isEmailValid, final User user) {	

        if (user.getPreferredChoice() == 1) {		
	    if (isEmailValid) {
	        System.out.println("EmailId already exists.");
		LoginPortal.signUpSignIn(user);
	    } 
	} else {
	    if (!isEmailValid) {
		System.out.println("Invalid login details. Reenter it.");
		LoginPortal.signUpSignIn(user);
	    }
	}
    }
	
   /**
    * Validates the password if the user is logging in.
    * @param user
    * @return
    */
    public static void checkPassword(final User user) {
	boolean isPasswordValid = authenticationController.validatePassword(user.getEmailId(),user.getPassword());
		
	    if (isPasswordValid) {
		System.out.println("Logged in successfully");
		LoginPortal.showProductDetails(user);
	    } else {
		System.out.println("Login unsuccessful.");
		LoginPortal.signUpSignIn(user);
	    }
    }
	
    /**
     * Shows the products available in the database.
     * @param user
     */
    public static void showProductDetails(final User user) {
		
        if (user.getTypeOfUser() == 1) {
	    AdminProductRole.showAdminChoice();
	} else {
	    ProductsAlteration.showProductDetails();	
	}
    }
}
