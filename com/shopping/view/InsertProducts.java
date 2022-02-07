package com.shopping.view;

import com.shopping.dao.Products;

/**
 * It is meant to receive input from user to insert.
 * @author AswiniN
 *
 */
public class InsertProducts {

	/**
	 * It gets product details.
	 * @return
	 */
	public static Products getProductDetails() {
		final Products products = new Products();
		
		System.out.println("Enter Product Name:");
		products.setProductName(LoginPortal.SCANNER.next());
		System.out.println("Enter Brand Name:");
		products.setBrandName(LoginPortal.SCANNER.next());
		System.out.println("Enter Price:");
		products.setPrice(LoginPortal.SCANNER.next());
		System.out.println("Enter Size:");
		products.setSize(LoginPortal.SCANNER.next());
		System.out.println("Enter User:");
		products.setUser(LoginPortal.SCANNER.next());
		System.out.println("Enter Quantity:");
		products.setQuantity(LoginPortal.SCANNER.nextInt());
		return products;	
	}
}
