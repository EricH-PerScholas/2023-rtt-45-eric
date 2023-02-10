package com.tek.java.day4;

public class Shape {
	
	// this means that only one variable x is create in memory for the entire JVM
	// this mostly gets used when your creating a constant
	public static String SHAPE_NAME = "Shape";
	
	// this does not include the static keyword
	public String NOT_STATIC = "Not static";
	
	public void setShapeName(String name) {
		SHAPE_NAME = name;
	}
	
	public void printShape() {
		System.out.println("I am a shape " + SHAPE_NAME);
		//shapeSize();
	}
	
	private void shapeSize() {
		System.out.println("Size of the shape");
	}
	
	public static void createShape() {
		System.out.println("this is a static method");
	}
}
