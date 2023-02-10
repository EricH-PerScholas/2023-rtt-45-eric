package com.tek.java.day4;

public class Day4Main {

	public static void main(String[] args) {
		Shape s = new Shape();
		s.printShape();
		System.out.println("Accessing shape name staticly from shape " + Shape.SHAPE_NAME);
		
		// however because our NOT_STATIC member variable is not static we must use an instance of the class
		// Shape.NOT_STATIC;   // this cant be done
		System.out.println(s.NOT_STATIC);  // this works because s has been create as a new object in memory 
		
		// this is calling the static method on the Shape object.
		// note that we do not need to use an instance .. this is similar to the Arrays class
		Shape.createShape();
		
		Shape.SHAPE_NAME = "XXXXXX";
 		
		System.out.println("============================");
		
		Square sq = new Square();
		sq.printShape(); // this is implemented on the parent shape function
		sq.printSquare(); // this is implemented on the square function
		
		System.out.println("============================");
		
		Circle c = new Circle();
		c.printShape(); // this is implemented on the parent shape function
		c.printCircle(); // this is implemented on the square function
	}

}
