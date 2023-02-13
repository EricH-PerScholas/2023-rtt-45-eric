package com.tek.java.day6.implement;

public class Triangle extends Shape {

	private int base;
	private int height;
	
	public void setBase(int base) {
		this.base = base;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public double calculateArea() {
		int area = base * height / 3;
		return area;
	}
	
	// we no longer need this method becasue we changed the parent Shape to have  get and set name
//	@Override
//	public String shapeName() {
//		return "Triangle";
//	}

}
