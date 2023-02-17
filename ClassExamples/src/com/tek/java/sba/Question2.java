package com.tek.java.sba;

public class Question2 {

	// position : 0 1 2 3 4 5
	// values   : a b c d e f
	
	// they are going to give you the size
	private static final int ARRAY_SIZE = 5;
	
	private int[] array;
	
	public static void main( String [] args ) {
		
		Question2 q2 = new Question2();
		
		int[] avg = { 1, 2, 3, 4 ,5, 6, 7};
		q2.calculateAverage(avg );
		
		q2.setValue(4);
		// print first message setting value
		
		q2.setValue(5);
		// print first message setting value
		
		q2.setValue(4);
		// print 2nd message because its already been changed
	}
	
	Question2() {
		// we need to make a 1 based data structure for an array of size 5
		// an array is 0 based so when we need 5 elements they go from 0 to 4
		// however since we are 1 based .. how many elements do we need
		
		// the key to this is to ignore the 0th element of the array
		// *********************************** THIS IS IMPORTANT TO ADD 1 to what ever they give you or it will array index out of bound
		array= new int[ ARRAY_SIZE + 1];
		
		// initialize this entire array to a value ... -1
		
		
	}
	
	public void calculateAverage(int[] arr) {
		// calculate the average
		// print out a message using system.out.format of the average with
		// decimal format this to show 2 places right of the decimal ( %.2f )
		// include a new line character at the end of the message
	}
	
	public void setValue(int index) {
		// if the value at array[index] == -1 then print a message saying that you set the value to 1
		// otherwise print a message saying that it was already changed
	}
	
	public void move(int value, int id ) {
		// if the value at array[id] == 1 then print a message saying "Value with id: {id} is moved to {value}" and set the value to -1
		// otherwise print a message saying "Value is already -1"
	}
}
