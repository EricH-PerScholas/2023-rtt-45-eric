package com.tek.java.day6.implement;

public class Square extends Shape {

	private int length;
	private int height;
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	// this is the implmenetation of the AreaCalculation interface
	@Override
	public double calculateArea() {
		int area = length * height;
		return area;
	}
	
	// this method overrides the toString function of Object which is the 
	// partent of all objects in Java.  Its there automatically and you dont need to do 
	// anything to use it.
	@Override
	public String toString() {
		return "The area of " + getShapeName() + " (length=" + length + ", height=" + height + ") is " + calculateArea() ;
	}
}
