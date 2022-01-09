package com.prime.store.bean;

public class CartItem {
	
	private Product product;
	
	private double quantity;
	
	public CartItem (Product product, double quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product Product) {
		this.product = Product;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
}
