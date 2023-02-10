package com.tek.java.coffee;

//this class is a POJO - Plain Old Java Object
//this class can also be referred to as a bean or entity
public class MenuItem {

	// these private varibles are call member variables
	// because they are defined at the class level meaning
	// they are available to the entire class not just the code block they are
	// defined in
	private String name = null;
	private double price = 0.0;
	private int quantityInStock = 0;

	// the constructor does not have a return type
	// by default all objects have an empty arguement constructor
	// that we do not have to code.
	public MenuItem() {

	}

	// this constructor takes in parameters that will populate the member
	// variables.  This consturctor needs to be able to tell the difference
	// between the arguement passed and the member variable of the class itself
	// by using this. it specifies the member variable of the class.
	// this. referrs to the instance of this class that is in memory
	public MenuItem(String name, double price, int quantityInStock) {
		this.name = name;
		this.price = price;
		this.quantityInStock = quantityInStock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

}
