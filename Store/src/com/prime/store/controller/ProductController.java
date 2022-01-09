package com.prime.store.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.prime.store.bean.Appliance;
import com.prime.store.bean.Beverage;
import com.prime.store.bean.Clothes;
import com.prime.store.bean.Food;
import com.prime.store.bean.Product;
import com.prime.store.bean.SizeEnum;

public class ProductController {
	
	private List<Product> products = new ArrayList<Product>();
	
	public List<Product> getProducts() {
		addProducts();
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProducts() {
		
		Food apples = new Food();
		apples.setId(1);
		apples.setName("apples");
		apples.setBrand("BrandA");
		apples.setPrice("$1.50");
		apples.setExpirationDate(LocalDate.parse("2021-06-14"));
		
		products.add(apples);
		
		Beverage milk = new Beverage();
		milk.setId(2);
		milk.setName("milk");
		milk.setBrand("BrandM");
		milk.setPrice("$0.99");
		milk.setExpirationDate(LocalDate.parse("2022-02-02"));
		
		products.add(milk);
		
		Clothes tshirt = new Clothes();
		tshirt.setId(3);
		tshirt.setName("T-shirt");
		tshirt.setBrand("BrandT");
		tshirt.setPrice("$15.99");
		tshirt.setSize(SizeEnum.M);
		tshirt.setColor("violet");
		
		products.add(tshirt);
		
		Appliance laptop = new Appliance();
		laptop.setId(4);
		laptop.setName("laptop");
		laptop.setBrand("BrandL");
		laptop.setPrice("$2345");
		laptop.setModel("ModelL");
		laptop.setProductionDate(LocalDate.parse("2021-03-03"));
		laptop.setWeight("1.125 kg");
		
		products.add(laptop);
		
		Appliance mobile = new Appliance();
		mobile.setId(5);
		mobile.setName("mobile");
		mobile.setBrand("BrandK");
		mobile.setPrice("$345");
		mobile.setModel("ModelK");
		mobile.setProductionDate(LocalDate.parse("2020-12-03"));
		mobile.setWeight("0.525 kg");
		
		products.add(mobile);
		
		Beverage juice = new Beverage();
		juice.setId(6);
		juice.setName("juice");
		juice.setBrand("KT");
		juice.setPrice("$1.99");
		juice.setExpirationDate(LocalDate.parse("2021-12-02"));
		
		products.add(juice);
		
		Food cheese = new Food();
		cheese.setId(7);
		cheese.setName("cheese");
		cheese.setBrand("CheeseMe");
		cheese.setPrice("$23.50");
		cheese.setExpirationDate(LocalDate.parse("2021-06-14"));
		
		products.add(cheese);
		
		Clothes jacket = new Clothes();
		jacket.setId(8);
		jacket.setName("jacket");
		jacket.setBrand("VikiSt");
		jacket.setPrice("$45.99");
		jacket.setSize(SizeEnum.XL);
		jacket.setColor("black");
		
		products.add(jacket);
	}
}
