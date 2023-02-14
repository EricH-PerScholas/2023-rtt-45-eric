package com.tek.java.day7;

public class StringBufferExample {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abcdefghi");
		
		System.out.println(sb);
		
		// arg 1 = start index
		// arg 2 = end index
		// arg 3 = what to replace it with
		// really this is doing 2 operations ... first is to delete the characters from position 0 (start index) to 5 (end index)
		// then inserts the characters in the string at position 0 (start index)
		sb.replace(0, 5, "12345890");
		
		System.out.println(sb);
		
		// this is one that adds the caracters at position 0
		sb.insert(0, "ABCD");
		
		System.out.println(sb);
	}

}
