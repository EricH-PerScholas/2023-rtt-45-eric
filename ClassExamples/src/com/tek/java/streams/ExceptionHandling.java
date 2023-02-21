package com.tek.java.streams;

import java.io.FileNotFoundException;

public class ExceptionHandling {

	public static void main(String[] args ) {
		
	}
	
	// throws : at the function level and can allow more than 1 checked exception to be thrown from a function
	// throw  : this is how we create a manual exception and will require the exception to be in the throws decliration in the signature
	// this is an example of checked exceptions - this means they must be explicitly decaired in the function signature
	// unchecked exception (ArrayIndexOutOfBound) can be thrown by this same method however, it does not need to be declaired in the signature
	public static void function() throws FileNotFoundException, Exception {
		 throw new Exception("this is manually throwing an exception");
	}
}
