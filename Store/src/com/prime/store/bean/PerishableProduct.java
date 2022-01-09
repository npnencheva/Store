package com.prime.store.bean;

import java.time.LocalDate;

public abstract class PerishableProduct extends Product {
	
	private LocalDate expirationDate;
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public int applyDiscount(LocalDate purchaseDate) {
		
		if (purchaseDate.isAfter(getExpirationDate().minusDays(5)) && purchaseDate.isBefore(getExpirationDate())) {
			return 10;
		}
		
		if (purchaseDate.equals(getExpirationDate())){
			return 50;
		}
		
		return 0;
	}
}
