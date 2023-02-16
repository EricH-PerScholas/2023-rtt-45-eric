package com.tek.java.day8;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	// List - ArrayList, Linked List
	// Set - HashSet ... 
	// Map - HashMap, TreeMap
	
	
	public static void main( String[] args ) {
		// Map<K,V>
		// this is a map with string as a key and string as a value
		Map<String,String> dictionary = new HashMap<>();
		dictionary.put("key", "value");
		dictionary.put("concat", "To add 2 strings together");
		dictionary.put("instanciate", "to create a new object");
		dictionary.put("new", "allocate new memory location");
		
		dictionary.remove("concat");
		
		Set<String> keySet = dictionary.keySet(); // this gives us the keys without the values
		for ( String key : keySet ) { // we are looping over the keys
			// printing they key and the value 
			// however we have to fetch the value from the map using the key
			System.out.println(key + " = " + dictionary.get(key)); 
		}
		
		System.out.println("==========================");
		
		
		
		// ==========================
		
		// this is a map with string as a key and integer as a value
		Map<String,Integer> intMap = new HashMap<>();
		intMap.put("key", 1);
		
		// this a map with the key as an integer and string as a value
		Map<Integer, String> sintMap = new HashMap<>();
		sintMap.put(1, "one");
		sintMap.put(2, "two");
		sintMap.put(3, "three");
		sintMap.put(4, "four");
		sintMap.put(5, "five");
		sintMap.put(6, "six");
		
		System.out.println(sintMap.get(3));
		
		sintMap.put(3, "THREE");		
		System.out.println(sintMap.get(3));
		
		
		for ( Integer key : sintMap.keySet() ) {
			
		}
	}
	
}
