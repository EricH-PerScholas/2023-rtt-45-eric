package com.tek.java.day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionsExamples {

	public static final void main(String[] args) {
		
		// a set is an unordered data structure that can only contain unique elements
		// adding an item to a set that is already there will overwrite the existing element in the set
		Set<String> set = new HashSet<String>();
		

		
		set.add("element1");
		set.add("element2");
		set.add("element3");
		set.add("element1"); // this item overwrites the first time we added the string element1
		
		for ( String e : set ) {
			System.out.println(e);
		}
		
		if ( set.isEmpty() ) {
			// the set has no elements
		}
		
		if ( set.size() == 0 ) {
			// same as is empty
		}
		
		System.out.println("================ creating a new list and print result ================");
		
		List<String> list = new ArrayList<>();
		
		// the list is an ordered data structure that can contain duplicate elements
		list.add("element1");
		list.add("element2");
		list.add("element3");
		list.add("element1");
		
		for ( String l : list ) {
			System.out.println(l);
		}
		
		if ( list.contains("element1") ) {
			// System.out.println("The list contains element1");
		}
		
		if ( list.isEmpty() ) {
			// generally if a list is empty it means there was no results
		}
		
		if ( list.size() == 0 ) {
			// this is the same as isEmpty
		}
		
		
		// this will get the first element of the list
		// however this should be checked to make sure the list is not empty otherwise it will throw an index out of bound exception
		//System.out.println(list.get(0));
		
		System.out.println("================ iterators  ================");
		
		// removing an element when not in a for loop is okay
		//list.remove(0);
		
		// this will remove the first element from the list
		// if you are doing a for over the list you can not use remove as it modifies the underlying data structure
		// which in turn causes problems with the for loop itself
		for ( int i = 0 ; i < list.size() ; i++ ) {
			if ( list.get(i).equals("element2") ) {
				list.remove(i);
			}
		}

		
		// an iterator is another way of looping over a list
		// this is not used very often and its primary use is if you want to delete an element from the list
		// this is the safe way of doing a delete
		Iterator<String> iterator = list.iterator();
		while ( iterator.hasNext() ) {
			String element = iterator.next();  // this has 2 effect, first is getting the element and then advancing the interator by 1
			if ( element.equals("element2") ) {
				iterator.remove();
			}
		}
	}
	
	public void printList( List<String> list ) {
		for ( String l : list ) {
			System.out.println(l);
		}
	}

	
}
