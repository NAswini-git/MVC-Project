package com.shopping.service;

import java.util.List;

import com.shopping.dao.Products;
/**
 * Interface to provide variation in products table.
 * @author AswiniN
 *
 */
public interface ProductsService {
	 List<Products> showProductDetails();
	
	 boolean insertProduct(Products products);
	 
	 public boolean deleteProducts(Products products);
	 
	 public boolean updateProducts(Products products);	 
}
