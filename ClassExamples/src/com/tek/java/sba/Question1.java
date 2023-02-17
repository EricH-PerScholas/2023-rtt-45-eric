package com.tek.java.sba;

import java.util.ArrayList;
import java.util.List;

// ***************  when making a new class in hacker rank do not use any access modifier ******************
// *************** make sure your output is exact .. and I mean exact .. no really I mean exactly like the requirements
// if you are off by even 1 space it will be wrong and test will not pass
public class Question1 {
	
	// String x = null;   this means that no string object has been created and there is no memory allocated
	// String y = "";  this is an empty string that has been allocated to memory
	
	//  ( x == null ) is true
	//  ( x.equals("") ) will throw a NullPointerException
	//  ( y.equals("") ) is true
	//  ( y == null ) is false
	
	public static void main(String [] args) {
		// how to transfer an array into an array list
		String[] arr = { "zero", "one", "two", "three", "four", "five" };
		
		Question1 q1 = new Question1();	
		q1.convert(arr);
		
		q1.replace(2);
		// i have replaced two with the empty string
		q1.replace(4);
		// i have replace four with the empty string
		
		List<String> compacted = q1.compact();
		// print compacted and should produce
		// zero, one, three, five
	}
	
	private ArrayList<String> list;
	
	Question1() {
		// in the constructor create a new array list
	}
	
	
	public void convert( String[] arr ) {
		// add the elements in the string array to the ArrayList of strings
	}
	
	public void replace(int idx) {
		// in an ArrayList write the value at idx to be an empty string
		// print a message saying what the value of the position in the list is and the value you are overwriting it with
	}
	
	public ArrayList<String> compact() {
		// remove all values in the array list that are empty strings
		// must use .equals and not ==
		return null;
	}
}
 