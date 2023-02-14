package com.tek.java.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerExample {

	public static void main(String[] args) {

		// the primary use of a string joiner is to create a CSV file
		// a CSV file in which the data is seperated by , or some other delimiter

		// 1st arg is deilimiter which will go between each element and seperates each element
		// 2nd arg is the start character
		// 3rd arg is the end character
		StringJoiner sj1 = new StringJoiner(":", "{", "}");

		sj1.add("element1");
		sj1.add("element2");
		sj1.add("element3");
		sj1.add("element4");
		
		System.out.println(sj1.toString());
		
		StringJoiner sj2 = new StringJoiner(",", "[", "]");

		sj2.add("list1");
		sj2.add("list2");
		sj2.add("list3");
		sj2.add("list4");
		
		System.out.println(sj2.toString());
		
		// by unsing the merge function it used the delimiter from sj1 for the elements from sj1 and the delimiter from sj2 on the elements from sj2
		// then used the start and end charcters from sj1
		//System.out.println(sj1.merge(sj2).toString());
		
		System.out.println(sj2.merge(sj1).toString());
				
	}

}
