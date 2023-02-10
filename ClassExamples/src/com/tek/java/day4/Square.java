package com.tek.java.day4;

public class Square extends Shape {
	

	
	@Override
	public void printShape() {
		// super means run it in the parent class
		// so in this case we are getting all of the functionality in the parent plus
		// the additional functionality in the child square
		super.printShape();
		System.out.println("This is a different implementstaion of pritn shape in the square");
	}
	
	public void printSquare() {
		System.out.println("I am a square and my parent SHAPE_NAME = " + SHAPE_NAME);
	}
	
	public void squareSize() {
		//this.shapeSize();
		
	}
}
