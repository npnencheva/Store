package com.prime.store.controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.prime.store.bean.CartItem;

public class Cashier {
	
	public void printReceipt ( List<CartItem> cart , LocalDateTime purchaseDateAndTime) {
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
		otherSymbols.setDecimalSeparator('.');
		DecimalFormat decimalFormatter = new DecimalFormat("'$'0.00", otherSymbols);
		decimalFormatter.setRoundingMode(RoundingMode.CEILING);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Date: " + purchaseDateAndTime.format(dateFormatter) + "\n\n");
		sb.append("---Products---");
		
		String name = "";
		String brand = "";
		double quantity = 0;
		double productPrice = 0;
		int discount = 0;
		double discountSum = 0;
		double totalPriceForProduct = 0;
		
		double subtotal = 0;
		double totalDiscount = 0;
		double total = 0;
		
		for (int i = 0; i < cart.size() ; i++) {
			name = cart.get(i).getProduct().getName();
			brand = cart.get(i).getProduct().getBrand();
			quantity = cart.get(i).getQuantity();
			
			Matcher matcherPriceAmount = Pattern.compile("(\\d+(\\.\\d+)?)").matcher(cart.get(i).getProduct().getPrice());
			while(matcherPriceAmount.find()){
				productPrice = Double.parseDouble(matcherPriceAmount.group(1));
			}
			
			totalPriceForProduct = quantity * productPrice;
			subtotal += totalPriceForProduct;
			
			discount = cart.get(i).getProduct().applyDiscount(purchaseDateAndTime.toLocalDate());
			
			discountSum = 0;
			
			sb.append("\n\n" + name + " " + brand + "\n");
			sb.append(quantity + " x " + decimalFormatter.format(productPrice) + " = " + decimalFormatter.format(totalPriceForProduct) + "\n");
			
			if (discount != 0) {
				discountSum = totalPriceForProduct * discount / 100;
				sb.append("#discount " + discount + "% -" + decimalFormatter.format(discountSum) + "\n");
			}
			
			totalDiscount += discountSum;
		}
		
		total = subtotal - totalDiscount;
		
		sb.append("-----------------------------------------------------------------------------------\n");
		sb.append("SUBTOTAL: " + decimalFormatter.format(subtotal) + "\n");
		sb.append("DISCOUNT: -" + decimalFormatter.format(totalDiscount) + "\n");
		sb.append("TOTAL: " + decimalFormatter.format(total) + "\n");
		
		System.out.print(sb);
	}
}
