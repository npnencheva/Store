package com.prime.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.prime.store.bean.CartItem;

public class CartController {
	
	private List<CartItem> cart  = new ArrayList<CartItem>();
	
	public List<CartItem> getCart() {
		addToCart();
		return cart;
	}

	public void setCart(List<CartItem> cart) {
		this.cart = cart;
	}

	public void addToCart() {

		ProductController productController = new ProductController();
		
		cart.add(new CartItem(productController.getProducts().stream()
				.filter(product -> product.getId() == 1)
				.collect(Collectors.toList()).get(0)
				, 2.45));
		cart.add(new CartItem(productController.getProducts().stream()
				.filter(product -> product.getId() == 2)
				.collect(Collectors.toList()).get(0)
				, 3));
		cart.add(new CartItem(productController.getProducts().stream()
				.filter(product -> product.getId() == 3)
				.collect(Collectors.toList()).get(0)
				, 2));
		cart.add(new CartItem(productController.getProducts().stream()
				.filter(product -> product.getId() == 4)
				.collect(Collectors.toList()).get(0)
				, 1));
	}
}
