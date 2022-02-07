package com.shopping.view;

import java.util.List;

import com.shopping.controller.ProductsController;
import com.shopping.dao.Products;

/**
 * To modify the data of products in the table.
 * @author AswiniN
 *
 */
public class ProductsAlteration {
	 static Products products = new Products();
	 final static ProductsController productController = new ProductsController();
	
	 /**
	 * To delete a product.
	 * @return
	 */
	public static Products getDeleteDetails() {	
		System.out.println("Enter Product Name:");
		products.setProductName(LoginPortal.SCANNER.next());
		System.out.println("Enter Brand Name:");
		products.setBrandName(LoginPortal.SCANNER.next());
		return products;
	}
	
	/**
	 * To update a product.
	 * @return
	 */
	public static Products getUpdateDetails() {
		 System.out.println("Enter Product Name:");
		 products.setProductName(LoginPortal.SCANNER.next());
		 System.out.println("Update Criteria: 1. Price 2. Quantity");
		 final int updateChoice = LoginPortal.SCANNER.nextInt();
		 
		 switch(updateChoice) {
		 case 1:
			 products = ProductsAlteration.getPrice();
			 break;
	     
		 case 2:
			 products = ProductsAlteration.getQuantity();
			 break;
		 }
		return products;
	}
    
	/**
	 * Get Quantity to update.
	 * @return
	 */
	private static Products getQuantity() {
		System.out.println("Enter the quantity to be changed");
		products.setQuantity(LoginPortal.SCANNER.nextInt());
		return products;
	}
    
	/**
	 * Get Price to update.
	 * @return
	 */
	private static Products getPrice() {
		System.out.println("Enter Price");
		products.setPrice(LoginPortal.SCANNER.next());
		return products;	
	}
	
	/**
	 *  Show the products available in the database.
	 */
	public static void showProductDetails() {
		List<Products> productsList = productController.showProductDetails();
		System.out.println(productsList);
	}
}
