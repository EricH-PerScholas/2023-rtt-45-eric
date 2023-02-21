package com.tek.java.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {

	public static final int PRINT_MENU = 1;
	public static final int ORDER_ITEM = 2;
	public static final int VIEW_CART = 3;
	public static final int EXIT = 4;

	// this is also a member variable that is private to this class
	// this private member variable can only be accessed from inside the coffee shop
	// class
	private List<MenuItem> menuItems = new LinkedList<>();

	private List<MenuItem> cart = new ArrayList<>();

	// all member variables are define at the top of the file
	private Scanner scanner = new Scanner(System.in);

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
		item2.setPrice(7.99);
		item2.setQuantityInStock(50);
		menuItems.add(item2);

		// this creates a new menu item using the constructor
		MenuItem item3 = new MenuItem("Small Cookie", 3.99, 5);
		menuItems.add(item3);

		// same as above but we are doing it in 1 line of code
		menuItems.add(new MenuItem("Egg Sandwich", 14.30, 4));
		
		// implmeneting compartitor as an anonymous block
		// Comparitor is an interface
		menuItems.sort(            // this is the sort function  being called on the menuItems list it self
		    new Comparator<MenuItem>() {  // this is an anonymous block that creates a new comparitor
		    	@Override  // we can not instanciate an interface so we must provide the implementation for that interface
				public int compare(MenuItem o1, MenuItem o2) {	 // right here in line
					Double p1 = o1.getPrice(); // these lines are implmenenting the sorting logic.
					Double p2 = o2.getPrice();
					
					return p1.compareTo(p2);
					
				} // this is the closing bracket for the compare method.
			} // this is the closing curley bracket for the compartior implementation
		); // this is the closing perenthses for the .sort method
		
		// single line of code that uses a java stream to sort by price
		// notice the :: notation in the syntax
		// the elements in the list are of time MenuItem and we are sorting byt he getPrice method / field
		// how to find this is to google for "java stream sort object by field"
		menuItems.sort(Comparator.comparing(MenuItem::getPrice));
	}

	public void printMenuItems() {

		System.out.println("Item Name\tPrice\tQuantity In Stock");
		System.out.println("---------\t-----\t-----------------");

		for (MenuItem item : menuItems) {
			System.out.println(item.getName() + "\t" + formatPrice(item.getPrice()) + "\t" + item.getQuantityInStock());
		}

		System.out.println("---------\t-----\t-----------------\n");
	}

	public int menuPrompt() {

		System.out.println("Welcome to Eric's coffee shop\n");
		System.out.println(PRINT_MENU + ") Print Menu");
		System.out.println(ORDER_ITEM + ") Order Item");
		System.out.println(VIEW_CART + ") View Cart");
		System.out.println(EXIT + ") Exit Coffee Shop");
		System.out.print("\nMake selection : ");

		int selection = scanner.nextInt();
		scanner.nextLine();

		System.out.println("");

		return selection;
	}

	public void orderItem() {
		printMenuItems();

		System.out.print("Enter item name: ");
		String itemName = scanner.nextLine();

		MenuItem selectedItem = findMenuItemByItemName(itemName);
		if (selectedItem != null) {
			System.out.println(selectedItem.getName() + " added to your cart.\n");
			cart.add(selectedItem);
		} else {
			System.out.println(itemName + " is not a valid selection.\n");
		}
	}

	// this function combines 2 activities - checking if the itemName exists and
	// returning the menuItem if the itemName does exist.
	// in this function the arg itemName represents the user input
	// this is a very common pattern in software engineering - every day used
	// if the method returns null then the itemName was not found : false = null
	// if the method returns a MenuItem the the itemName was found.
	private MenuItem findMenuItemByItemName(String itemName) {
		// if the incoming itemName string is not instanciated (null)
		// the it can never be equal to a menu item.
		if (itemName == null) {
			return null;
		}

		// we want to trim any white space before or after the user input
		itemName = itemName.trim();

		for (MenuItem menuItem : menuItems) {
			// the menuItem.getName function returns a string
			String name = menuItem.getName();
			// the string object contains a method called equalsIgnoreCase
			if (name.equalsIgnoreCase(itemName)) {
				return menuItem;
			}
		}

		// we got here without match so we know we did not find
		// the itemName in the list of menuItems
		return null;
	}

	public void viewCart() {
		System.out.println(cart.size() + " items in your cart:\n");

		double totalPrice = 0.0;

		System.out.println("Item Name\tPrice");
		System.out.println("---------\t-----");
		for (MenuItem item : cart) {
			System.out.println(item.getName() + "\t" + formatPrice(item.getPrice()));
			totalPrice = totalPrice + item.getPrice();
		}

		System.out.println("---------\t-----");

		System.out.println("Total Price\t" + formatPrice(totalPrice));
		System.out.println("");
	}

	private String formatPrice(double price) {
		DecimalFormat df = new DecimalFormat("$###.00");
		String formattedPrice = df.format(price);

		return formattedPrice;
	}
}
