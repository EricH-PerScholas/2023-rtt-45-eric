package com.tek.java.day1;

public class TypeCastingExample {

	// Write a program that declares two integer variables, x, and y, and assigns 5 to x and 6 to y. 
	// Declare a variable q and assign y/x to it and print q. 
	// Now, cast y to a double and assign it to q. Print q again.

	
	public static void main(String[]args ) {
		int x = 5;
		int y = 6;
		
		// be cause we did not cast the integers to a double we lost the precision
		double q = y/x;
		System.out.println(q);
		
		// however if we cast both x and y to a double then we preserve the precision
		q = (double)y / (double)x;
		System.out.println(q);
		
		// y is the whole number 6
		q = (double)y;
		// by casting y to a double we change it from the whole number 6 to a fractional number 6.0
		System.out.println(q);
	}
}
