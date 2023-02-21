package com.tek.java.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Larry");
		names.add("Steven");
		names.add("Eric");
		names.add("Jessica");
		names.add("Ellen");

		// 1) sort the original names list by length of name using a stream.
		names.sort(Comparator.comparingInt(String::length));
		System.out.print(String.join("\n", names) + "\n");

		System.out.println("======================================");

		// 2) when the legnth is the same then sort alphabetically
		names.sort(Comparator.comparingInt(String::length).thenComparing(x -> x.toLowerCase()));
		System.out.print(String.join("\n", names) + "\n");

		System.out.println("======================================");
		
		
		List<String> sortedList = names.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());	 // this will create a new list without altering the original list
		System.out.print(String.join("\n", sortedList) + "\n");
		
		System.out.println("======================================");
		
		// remove all names from the list that contain an "n"
		sortedList.removeIf(name -> name.contains("n")); 
		System.out.print(String.join("\n", sortedList) + "\n");	
		

	}
}
