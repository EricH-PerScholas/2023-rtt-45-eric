package com.tek.java.day6.implement;

public class Circle extends Shape {
	// PI * r * r
	
	private static final double PI = 3.14159;
	
	private int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public double calculateArea() {
		double area = PI * radius * radius;
		return area;
	}
}
