package com.prime.store.bean;

import java.time.LocalDate;

public interface Discountable {
	
	 public int applyDiscount(LocalDate purchaseDate);
	 
}
