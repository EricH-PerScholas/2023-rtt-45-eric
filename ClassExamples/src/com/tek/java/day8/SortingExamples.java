package com.tek.java.day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingExamples {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(13);
		numbers.add(7);
		numbers.add(18);
		numbers.add(5);
		numbers.add(2);
		
		System.out.println("Before : " + numbers);
		
		// this is using a static utility method on the Collections object - collections is a set of tools
		//Arrays.sort()
		Collections.sort(numbers);
        System.out.println("After : " + numbers);
        
        // this is using the sort function on teh array list itself
        // what we are doing is passing in a comparitor - a comparitor implements a custom sort.
        numbers.sort(Comparator.reverseOrder());
        System.out.println("Reverse : " + numbers);
        
	}
	
	// a comparitor is just an interface and we are implmeneting it
	class NumberComparitor<Integer> implements Comparator<Integer> {
	
		// comparitor returns 3 values
		// if o1 < o2 then return -1
		// if o1 == o2 then return 0
		// if o1 > o2 then return 1
		
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
 }
