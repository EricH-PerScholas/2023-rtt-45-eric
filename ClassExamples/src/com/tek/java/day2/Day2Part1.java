package com.tek.java.day2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Day2Part1 {

	public static void main(String[] args) {
		Day2Part1 d2 = new Day2Part1();
		//d2.autobox();
		//d2.character();
		//d2.escapeSequence();
		//d2.stringsEqual();
		//d2.stringMethods();
		//d2.numberToStringConversion();
		//d2.stringBufferExample();
		//d2.stringJoinerExample();
		d2.formatting();
	}
	
	public void formatting() {
		int i = 1024;
		byte b = 127;
		int f = 234234;
		double d = 1.236;
		double tiny = d / 1000000.0;
		
		// this is hard to read
		System.out.format("This is an integer: %d and this is a byte: %d and finally %d.\n", i, b, f);
		
		// this is easier to read
		// on the job using system out println is forbidden
		// you will be using a logging framework to write output to a specific place.
		System.out.println("This is an integer: " + i + " and this is a byte: " + b + " and finally " + f);
		
		
		// this notation is on the SBA I think ... maybe it has changed probably not
		// ******** FOR THE KBA YOU WILL NEED TO FORMAT A DECIMAL NUMBER TO 2 PLACES ***************
		// note that when you format to 2 decimal places it rounds as necessary
		System.out.format("This is a double: %.4f and this is tiny: %.4e.\n", d, tiny);
		// the difference here is %.4f which is 4 decimal and %.2f is 2 decimal places
		System.out.format("This is a double: %.2f and this is tiny: %.4e.\n", d, tiny);

		// !!!!!!!!!!!!!! this is how you will do it on the job.  Learn this way and do this on the KBA !!!!!!!!!!!!!!
		// !!!!!!!!!!!!!! of all this ... this is the important way to know how to do !!!!!!!!!!!!!!
		double number = 123456789.123;
		String pattern = "##,###,###.##";
	    DecimalFormat numberFormat = new DecimalFormat(pattern);
	    System.out.println("Using decimal format " + numberFormat.format(number));

	}
	
	// TODO : Homework / Examples ... run this code and try to understand what it is doing
	public void stringJoinerExample() {
		StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter
		
		joinNames.add("Java");
		joinNames.add("Python");
		joinNames.add("C Sharp");
		joinNames.add("Javascript");

		System.out.println(joinNames);
		
		// whithout a string joiner
		// making a list with 4 items and I want them to print out the same as above
		List<String> lng = new ArrayList<>();
		lng.add("Java");
		lng.add("Python");
		lng.add("C Sharp");
		lng.add("Javascript");
		
		for ( int i = 0 ; i < lng.size() ; i++ ) {
			System.out.print(lng.get(i));
			if ( i < lng.size() - 1 ) {
				System.out.print(",");
			}
		}
	}

	public void stringBufferExample() {
		// string buffer is an object that is mutable
		StringBuffer str = new StringBuffer();
		
		str.append("abc");
		str.append("xyz");
		
		System.out.println(str);
		
		// java is not creating a new string each time.  
		// this will actually create 3 strings in memory
		// 1) abc
		// 2) xyz
		// 3) abcxyz
		String x = "abc" + "xyz";
	}
	
	public void numberToStringConversion() {
		String str = "123";
		int b = Integer.parseInt(str);
		
		// this can work because we converted the string to a number and then can do
		// mathmatical operations
		int c = b + 5;
		
		// this can not work because str is a string
		//int c = str + 5;
		
		// this is not bullet proof as this code will cause an exception to be thrown
		Integer.parseInt("abc");
	}
	
	public void stringMethods() {
		String x = "     asdfabasdf     ";
		System.out.println("Before Trim ->" + x + "<-");
		System.out.println("After  Trim ->" + x.trim() + "<-");
		System.out.println("Substring   ->" + x.substring(6,10) + "<-");
	}
	
	public void stringsEqual() {
		String a = "abcd";
		String b = "wxyz";
	
		// For the sake of this course and what we are doing here ALWAYS use the .equals method to compare 
		// if 2 strings are the same
	
		// WARNING : doing this incorrectly will produce a bug in your code as it will be correct
		// sometimes but not others.
		
		if ( a == b ) {
			// this will never be true because java compares the memory location
			// this is different than how it works with primitives which is compared by value
			// you can only count on this when it is a primitive
			System.out.println("This will not execute");
		} else {
			System.out.println("This will always be false even tho the values are different");
		}
		
		
		if ( a.equals(b) ) {
			// this will compare the value of a and b and only if the values are equal will it enter this block		
			// this block will not execute.
		} else {
			System.out.println("This will evaluate to false becasue the value of a is not equal to the value of b");
		}
		
		String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");
 
        System.out.println(s1 == s2); // true  ( this is true because of string literals in memory)
        System.out.println(s1 == s3); // false ( false because the memory locations are different)
        System.out.println(s1.equals(s2)); // true ( comparison based on value )
        System.out.println(s1.equals(s3)); // true ( comparison based on value )
	}
	

	public void autobox() {
		// for the most part a primitive and a wrapper class are interchangeable with no worries
		int a = 50;
		Integer i = a;
		
		// as a primitive a does not have any functions on it
		// but as the wrapper class it does functions
		i.doubleValue();
		i.longValue();
		
		// in the past before auto boxing we had to do something like this to convert from int to Intger
		Integer x = Integer.valueOf(a);
		
		// the wrapper class allows you to set it to null which means it has not value
		// this can not be done with a primitive :  a = null;  will not compile
		Integer n = null;
		if ( n == null ) {
			// do some code
		}
	}
	
	public void character() {
		// all of the same primitive concepts above will also work with char
		// also a primitive that we can not call functions on
		char d = 'D';
		
		// using the wrapper 
		Character c = 'C';
		System.out.println("The lowercase of Z is " + Character.toLowerCase('Z'));
		
		System.out.println("The char C is a digit? " + Character.isDigit('C'));
		System.out.println("The char 1 is a digit? " + Character.isDigit('1'));
	}
	
	public void escapeSequence() {
		System.out.println("This is a string with a \" and a \\ in it ");
		System.out.println("This is a string with a new line character \n in it");
		System.out.println("This is a string with a tab\tin it and 4 spaces ->    <-");
	}

}
