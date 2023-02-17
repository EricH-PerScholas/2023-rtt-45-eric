package com.tek.java.sba;

import java.util.ArrayList;

public class Question1 {
	
	// String x = null;   this means that no string object has been created and there is no memory allocated
	// String x = "";  this is an empty string that has been allocated to memory
	
	public static void main(String [] args) {
		// how to transfer an array into an array list
		String[] arr = { "one", "two", "three" };
		
		Question1 q1 = new Question1();	
		q1.convert(arr);
	}
	
	private ArrayList<String> list;
	
	public Question1() {
		// in the constructor create a new array list
	}
	
	
	public void convert( String[] arr ) {
		// add the elements in the string array to the list of strings
	}
	
	public void replace(int idx) {
		// in an ArrayList write the value at idx to be an empty string
		// print a message saying what the value of the position in the list is and the value you are overwriting it with
	}
	
	public ArrayList<String> compact() {
		// remove all values in the array list that are empty strings
		return null;
	}
}
 