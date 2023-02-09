package com.tek.java.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {

	// this is also a member variable that is private to this class
	// this private member variable can only be accessed from inside the coffee shop
	// class
	private List<MenuItem> menuItems = new ArrayList<>();
	
	public void initialize(int count) { 
	}

	public void initialize() {
		// all 4 of these menuItems are doing the same thing with different ways of
		// doing it
		MenuItem item1 = new MenuItem();
		item1.setName("Small Coffee");
		item1.setPrice(4.30);
		item1.setQuantityInStock(50);
		menuItems.add(item1);

		MenuItem item2 = new MenuItem();
		item2.setName("Large Coffee");
		item2.setPrice(5.99);
		item2.setQuantityInStock(50);
		menuItems.add(item2);

		// this creates a new menu item using the constructor
		MenuItem item3 = new MenuItem("Small Cookie", 9.99, 5);
		menuItems.add(item3);

		// same as above but we are doing it in 1 line of code
		menuItems.add(new MenuItem("Egg Sandwich", 14.30, 4));
	}

	public void printMenuItems() {
		
		System.out.println("Item Name\tPrice\tQuantity In Stock");
		System.out.println("---------\t-----\t-----------------");

		for (MenuItem item : menuItems) {
			DecimalFormat df = new DecimalFormat("$###.00");
			String formattedPrice = df.format(item.getPrice());
			System.out.println(item.getName() + "\t" + formattedPrice + "\t" + item.getQuantityInStock());	
		}
		
	}
}
