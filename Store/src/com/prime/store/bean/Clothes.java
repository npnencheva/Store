package com.prime.store.bean;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Clothes extends Product {
	
	private SizeEnum size;

	private String color;

	public void setSize(SizeEnum size) {
		this.size = size;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public SizeEnum getSize() {
		return size;
	}
	
	@Override
	public int applyDiscount(LocalDate purchaseDate) {
		
		if (!isWeekend(purchaseDate)) {
			return 10;
		}
		
		return 0;
	}
	
	public boolean isWeekend(LocalDate purchaseDate) {
        DayOfWeek day = purchaseDate.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
