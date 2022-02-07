package com.shopping.view;

import java.util.InputMismatchException;

import com.shopping.controller.ProductsController;
import com.shopping.dao.Products;

/**
 * Get the choice for modification of products by admin.
 * 
 *@author AswiniN
 */
public class AdminProductRole {
    final static ProductsController productController = new ProductsController();
	
    /**
     * Shows the choice from admin.
     */
    public static void showAdminChoice() {	
	System.out.println("1. INSERT  2. VIEW  3. UPDATE  4. DELETE ");
	int adminChoice = 0 ;
	Products products = new Products();
		
	try {
            adminChoice = LoginPortal.SCANNER.nextInt();
	} catch(InputMismatchException e) {
	    System.out.println("You should enter a valid input!");
	    LoginPortal.registerPortal();
	}
		
	switch(adminChoice) {
	    case 1: 
		products = InsertProducts.getProductDetails();
		checkInsertion(products);	
	        break;
		
       	    case 2:
		ProductsAlteration.showProductDetails();
		AdminProductRole.showAdminChoice();
		break;
		
	    case 3:
		products = ProductsAlteration.getUpdateDetails();
		checkUpdation(products);
		break;
		
	    case 4:
		products = ProductsAlteration.getDeleteDetails();
		checkDeletion(products);
		break;
			
	    default:
		System.out.println("Enter choice 1 to 4.");
		AdminProductRole.showAdminChoice();
	    }
    }
    
    /**
     * Check table for insertion.
     *
     * @param products
     */
    private static void checkInsertion(Products products) {
	boolean isInserted = productController.insertProduct(products);
		
	if(isInserted) {
	    System.out.println("Successfully inserted");
	} else {
	    System.out.println("Insertion failed!! Try again.");
	}
	    AdminProductRole.showAdminChoice();
    }
	
    /**
     * Check table for update.
     *	
     * @param products
     */
    private static void checkUpdation(Products products) {
	boolean isUpdated = productController.updateProducts(products);
		
        if (!isUpdated) {
	    System.out.println("Successfully updated. !!");
	} else {
	    System.out.println("Updation failed! Try again.");
	}
	    AdminProductRole.showAdminChoice();
    }
	
    /**
     * Check table for deletion.
     * @param products
     */
    private static void checkDeletion(Products products) {
	boolean isDeleted = productController.deleteProduct(products);
		
	if(isDeleted) {
	    System.out.println("Successfully Deleted");
	} else {
	    System.out.println("Deletion failed!! Product may not be available.");
	}
	    AdminProductRole.showAdminChoice();
    }
}
