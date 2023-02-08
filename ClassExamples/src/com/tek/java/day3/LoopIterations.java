package com.tek.java.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoopIterations {

	public static void main(String[] args) {
		LoopIterations li = new LoopIterations();
		// li.forLoop();
		// li.forLoopList();
		// li.forListExercise(5, 8);
		// li.whileLoop(5, 10);
		li.maxRandomValue(1, 500, 1000);
	}

	// excercise .. make this take 3 paramter inputs
	// the min random value, the max random value, and the number of elements in the
	// list ... we pass maxRandomValue(1,100,10)
	public void maxRandomValue(int smallest, int largest, int length) {
		List<Integer> list = new ArrayList<>();

		// this code adds 10 random numbers to the list
		for (int i = 1; i <= length; i++) {
			Random rand = new Random();
			int randomNum = rand.nextInt((largest - smallest) + 1) + smallest;

			list.add(randomNum);
			
			System.out.println(randomNum);
		}

		int minValue = list.get(0);
		// int minValue = 100;
		int maxValue = 0;
		for (Integer r : list) {
			if (r > maxValue) {
				maxValue = r;
			}
			if (r < minValue) {
				minValue = r;
			}
		}

		System.out.println("Max value = " + maxValue);
		System.out.println("Min value = " + minValue);
	}

	public void whileLoop(int start, int end) {
		List<Integer> list = new ArrayList<>();

		int i = start;
		while (i <= end) {
			list.add(i);
			i = i + 1;
		}

		for (Integer e : list) {
			System.out.println(e);
		}
	}

	// TODO ... create a List of Integers and use a loop to add the numbers 1 to 10
	// to the the list. The use the new style for loop to print the elements in the
	// list.
	public void forListExercise(int start, int end) {
		List<Integer> list = new ArrayList<>();

		for (int i = start; i <= end; i++) {
			list.add(i);
		}

		for (Integer e : list) {
			System.out.println(e);
		}
	}

	// position : 0 contains "String 1"
	// position : 1 contains "String 2"
	// position : 2 contains "String 3";
	// Ctrl - shift - O to import classes List and ArrayList
	public void forLoopList() {
		List<String> list = new ArrayList<>();
		list.add("String 1");
		list.add("String 2");
		list.add("String 3");

		// loop over the list and print elements
		// this loop is only is used when you need have a specific requirement to know
		// the]
		// position of each element
		// for some sort of business logic ... this does happen from time to time
		for (int position = 0; position < list.size(); position++) {
			System.out.println(list.get(position));
		}

		System.out.println("=================================");

		// new style for loop that is easier to read and used more commonly.
		// in my mind I read this as ... for each element in the list .. do something
		for (String element : list) {
			System.out.println(element);
		}

	}

	// EXAMPLES - Loop from 10 to 30 showing even numbers only and using continue
	// Loop from 10 to 1 showing all numbers
	// Loop from 10 to 30 and break when you find the first number divisible by 3

	public void forLoop() {
		// loop 1 to 10 increment by 1
		for (int count = 1; count <= 10; count++) {
			System.out.println("Value of count = " + count);
		}

		System.out.println("=================================");

		// loop 1 to 2 increment by 2 (odd numbers printed);
		for (int count = 1; count <= 10; count += 2) {
			System.out.println("Value of count = " + count);
		}

		System.out.println("=================================");

		// loop 10 to 50 increment by 2 (even numbers printed)
		for (int count = 10; count <= 50; count += 2) {
			System.out.println("Value of count = " + count);
		}

		System.out.println("=================================");

		// loop 10 to 1 decrement by 1 (even numbers printed)
		for (int count = 10; count >= 1; count--) {
			System.out.println("Value of count = " + count);
		}

		System.out.println("=================================");

		// loop 1 to 10 increment by 1 - set count inside of loop to cause exit
		// this will not be used often - maybe once every few years its just an example
		// that you can modify the count
		for (int count = 1; count <= 10; count++) {
			System.out.println("Value of count = " + count);
			count = 10;
		}

		System.out.println("=================================");

		// loop 1 to 10 using a break to exit after first iteration
		for (int count = 1; count <= 10; count++) {
			System.out.println("Value of count = " + count);
			break;
		}

		System.out.println("=================================");

		// loop 1 to 10 using a continue to print only even numbers
		for (int count = 1; count <= 10; count++) {
			if (count % 2 == 1) {
				// this gets us odd numbers
				continue;
			}

			System.out.println("Value of count = " + count);
		}

	}
}
