package com.tek.java.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayExamples {

	public static void main(String[] args) {
		ArrayExamples ae = new ArrayExamples();
		//ae.createArray();
		ae.maxRandomValue(1, 10, 10);
		ae.deleteElement();
	}
	
	
	public void deleteElement() {
		int[] arr = new int[10];
		
		int[] arr1;
		arr1 = new int[10];
		
		// first we fill our array
		for ( int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = i;
		}
		System.out.println("Array fileld\t\t" + Arrays.toString(arr));
		
		// delete element 2
		arr[2] = 0;
		System.out.println("Position 2 set to 0\t" + Arrays.toString(arr));
		for ( int i = 3 ; i < arr.length ; i++ ) {
			arr[i-1] = arr[i];
		}
		
		System.out.println("Array shifte\t\t" + Arrays.toString(arr));
		arr[arr.length-1] = 0;
		
		System.out.println("Final position 0\t" + Arrays.toString(arr));
	}
	

	// excercise .. make this take 3 paramter inputs
	// the min random value, the max random value, and the number of elements in the
	// list ... we pass maxRandomValue(1,100,10)
	public void maxRandomValue(int smallest, int largest, int length) {

	}

	public void createArray() {
		// notice that we are using a new keyword with the array even tho its a
		// primitive
		int[] values = new int[10];

		// here we use () to create a new object which is essentially call the
		// constructor of the object
		String str = new String();

		// not here when we are creating an array we are not using () because we need to
		// specify the
		// array size using []
		String[] strings = new String[10];

		strings[0] = "a"; // pos 0
		strings[1] = "b"; // pos 1
		strings[2] = "c"; // pos 2
		strings[9] = "z"; // pos 9

		// to a value from the array we use
		System.out.println(strings[2]);

		// if we do this with a list
		List<String> list = new ArrayList<>();
		list.add("a"); // pos 0
		list.add("b"); // pos 1
		list.add("c"); // pos 2

		System.out.println(list.get(2));

		// creating an array with constants
		int[] constants = { 1, 5, 7, 9, 10 };
		String[] fileExt = { ".jpg", ".txt", ".exe" };

		// first we look at old for loop on array
		for (int pos = 0; pos < strings.length; pos++) {
			System.out.println("Position " + pos + " = " + strings[pos]);
		}

		System.out.println("=================================");

		// we can also do a new for loop on array
		for (String s : strings) {
			System.out.println(s);
		}

		// the length of the array can be defined as a variable
		int len = 10;
		int[] lenArray = new int[len];
	}
}
