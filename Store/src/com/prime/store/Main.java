package com.prime.store;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.prime.store.controller.CartController;
import com.prime.store.controller.Cashier;

public class Main {

	public static void main(String[] args) {
		
		CartController cart = new CartController();
		
		Cashier cashier = new Cashier();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		cashier.printReceipt(cart.getCart(), LocalDateTime.parse("2021-06-14 12:34:56", formatter));
		
	}
}
