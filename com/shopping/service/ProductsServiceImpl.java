package com.shopping.service;

import java.util.List;

import com.shopping.dao.Products;
import com.shopping.dao.ProductsAlterationDAO;
import com.shopping.dao.ProductsDAO;

/**
 * Implementing class for data modification in product table.
 * 
 *@author AswiniN
 */
public class ProductsServiceImpl implements ProductsService {
    private static final ProductsDAO PRODUCTS_DAO = new ProductsDAO();
    private static final ProductsAlterationDAO  MODIFY_PRODUCTS_DAO = new ProductsAlterationDAO();
	
    /**
    * To show the products available. 
    */
    public List<Products> showProductDetails() {
	System.out.println("Available products are:");
	return PRODUCTS_DAO.selectAllProducts();
    }
    
    /**
    * To insert product.
    */
    public boolean insertProduct(Products products) {
	return MODIFY_PRODUCTS_DAO.insertProduct(products);
    }
	
    /**
    * To delete product.
    */
    public boolean deleteProducts(Products products) {
        return MODIFY_PRODUCTS_DAO.deleteProduct(products); 
    }
    
    /**
    * To update product.
    */
    public boolean updateProducts(Products products) {
	return MODIFY_PRODUCTS_DAO.updateProduct(products);
    }
}
