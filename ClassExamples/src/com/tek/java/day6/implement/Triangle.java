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
	
	// this method is forced by the interface on the Shape class
	@Override
	public double calculateArea() {
		int area = base * height / 2;
		return area;
	}
	
	
	@Override
	public String toString() {
		StringBuffer response = new StringBuffer();
		response.append("The area of ");
		response.append(getShapeName());
		response.append(" (base=");
		response.append(base);
		// the rest of the string .... 
		
		// this calls the toString method to convert the StringBuffer to an immutable string
		response.toString();
		
		return "The area of " + getShapeName() + " (base=" + base + ", height=" + height + ") is " + calculateArea() ;
	}
}
