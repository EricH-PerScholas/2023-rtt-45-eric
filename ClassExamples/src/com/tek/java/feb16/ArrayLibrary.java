package com.tek.java.feb16;

import java.util.Arrays;

public class ArrayLibrary {


	public void printArray(int[] arr, String message) {
		System.out.println(message + "\t= " + Arrays.toString(arr));
	}

	// append 'value' to the end of the array and return it
	public int[] append(int[] arr, int value) {
		// 1 create a new array that is 1 larger than the size of arr
		int[] copy = new int[arr.length + 1];

		// 2 copy all elements from arr into the new copy using a for loop
		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		
		// set the value to the last position
		copy[copy.length-1] = value;
		
		return copy;
	}

	public int[] insertElement(int[] arr, int position, int value) throws NegativePositionException,PoisitionToLargeException {
		// first thing when you enter a function is to test your inputs
		if ( position < 0 ) {
			throw new NegativePositionException("Position must be greater than 0");
		}
		
		if ( position >= arr.length ) {
			throw new PoisitionToLargeException("Position must be less than " + arr.length);
		}
		
		
		int[] copy = append(arr,0);
		//printArray(copy, "Copy initialized to");

		// 3 move all elements in the array starting at position to the end 1 space to
		// the right
		// copy[i+1] = copy[i]
		for (int i = position; i < arr.length; i++) {
			copy[i + 1] = arr[i];
		}
		//printArray(copy, "Copy shifted right");

		// 4 set arr[position] = number
		copy[position] = value;
		// printArray(copy, "New value set on copy");

		// 5 return the new array
		return copy;
	}

	public int[] deleteElement(int arr[], int position) {
		// 1 starting at position to the end of arr shift everything left
		for (int i = position + 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		//printArray(arr, "Array shifted left");
		
		// 2 make a new arr of size 1 smaller
		int[] copy = new int[arr.length - 1];
		
		// 3 copy arr into your copy arry minus the last element
		for (int i = 0; i < copy.length; i++) {
			copy[i] = arr[i];
		}
		
		// 4 profit	
		return copy;
	}

	public int[] bubbleSort(int arr[]) {
		// 1 - outer loop that will move across the entire array
		// 2 - inner loop that moves across the entire array
		// 3 - compare element at arr[inner] with arr[inner+1]
		// 4 - if arr[inner] < arr[inner+1] then swap the elements
		// 5 - use a temp variable to store one value
		// 6 - move the other value
		// 7 - put the temp value into the one you just moved
		// 8 - return the array
		for (int outer = 0; outer < arr.length; outer++) {
			for (int inner = 0; inner < arr.length -1; inner++) {
				if (arr[inner] < arr[inner + 1]) {
					int temp = arr[inner];
					arr[inner] = arr[inner + 1];
					arr[inner + 1] = temp;
				}
			}
		}
		
		return arr;
	}

	public int findPositionOfValue(int arr[], int value) {
		// find the position of the incoming value
		// if the value is not found then return -1
		// return the first element found
		int position = -1;
		
		for ( int i = 0 ; i < arr.length ; i++ ) {
			if ( arr[i] == value ) {
				position = i;
				break;
			}
		}
		
		return position;
	}

}
