package com.shopping.controller;

import java.util.List;

import com.shopping.dao.Products;
import com.shopping.service.ProductsService;
import com.shopping.service.ProductsServiceImpl;

/**
 * It controls the flow between view and service implementation for product table.
 * @author AswiniN
 *
 */
public class ProductsController {
    private static final ProductsService PRODUCTS_SERVICE = new ProductsServiceImpl();
	
    /**
     * Shows the products.
     * @return
     */
    public List<Products> showProductDetails( ) {
		return PRODUCTS_SERVICE.showProductDetails();	
	}
    
    /**
     * Insert the product.
     * @param products
     * @return
     */
    public  boolean insertProduct(Products products) {
		return PRODUCTS_SERVICE.insertProduct(products);
    }
    
    /**
     * Delete the product.
     * @param products
     * @return
     */
	public boolean deleteProduct(Products products) {
		return PRODUCTS_SERVICE.deleteProducts(products);
	}
    
	/**
	 * Update the product.
	 * @param products
	 * @return
	 */
	public boolean updateProducts(Products products) {
		return PRODUCTS_SERVICE.updateProducts(products);
	}

	

}
