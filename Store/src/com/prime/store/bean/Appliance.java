package com.prime.store.bean;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Appliance extends Product {
	
	private String model;
	
	private LocalDate productionDate;
	
	private String weight;
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	@Override
	public int applyDiscount(LocalDate purchaseDate) {
		
		double price = 0;
		
		Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
		Matcher matcher = regex.matcher(getPrice());
		while(matcher.find()){
			price = Double.parseDouble(matcher.group(1));
		}
		if (price > 999 && isWeekend(purchaseDate)) {
			return 5;
		}
		
		return 0;
	}
	
	public boolean isWeekend(LocalDate purchaseDate) {
        DayOfWeek day = purchaseDate.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
