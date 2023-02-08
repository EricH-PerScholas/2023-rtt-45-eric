package com.tek.java.day2;

public class HackerRank {

	/*
	 * 
	 * 10 <- this is the number of tokens
	 * 
	 * He is a very very good boy isn t he
	 */

	public static void main(String[] args) {
		// first im defining my input
		//String input = "He is a very very good boy, isn't he?";
		String input = "            		YES      leading spaces        are valid,   problemsetters are         evillllll      ";
		System.out.println("->" + input + "<-");
		
		input = input.trim();
		System.out.println("->" + input + "<-");
		
		// this line is splitting the string on a non word character
		// and gives us back an array of strings - each one is a token
		String[] tokens = input.split("[\\W]+");
		System.out.println(tokens.length);

		for (String token : tokens) {
			System.out.println("->" + token + "<-");
		}

		System.out.println("============================");
	}

}
