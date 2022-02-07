package com.shopping.dao;

/**
 * POJO class for products table. 
 * @author AswiniN
 *
 */
public class Products {
	private String productName;
	private String brandName;
	private String price;
	private String size;
	private String user;
	private int quantity;
	
	public Products() {
		
	}
	
	public Products(String productName, String brandName, String price, String size, String user, int quantity) {

	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return "Products: " + productName+ "," +brandName +","+price+","+size+","
		        +user+","+quantity+"";
	}
	

}
