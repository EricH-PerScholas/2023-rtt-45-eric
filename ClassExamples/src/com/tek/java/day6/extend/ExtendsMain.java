package com.tek.java.day6.extend;

import java.util.ArrayList;
import java.util.List;

public class ExtendsMain {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.animalSound();
		a.animalEats();
	
		Animal p = new Pig();  // this is an example of upcasting
		p.animalSound();
		p.animalEats();
		//p.anotherMethod();
		
		Dog d = new Dog();
		d.animalSound();
		d.animalEats();
		

		System.out.println("================================");
		
		// this is upcastign each object to animal so it can go in the list
		// upcasting does not need any syntax to do it 
		// the compiler is doing it automatically for us
		List<Animal> animals = new ArrayList<>();
		animals.add(a);
		animals.add(p);
		animals.add(d);
		
		for ( Animal animal : animals ) {
			animal.animalSound();
			if ( animal instanceof Pig ) {  // this allows us to tell if the object is a pig
				Pig pig = (Pig)animal;  // this is an example of down casting
				pig.anotherMethod();  // by down casting we gain access to the methods only implmented in the pig object
			}
		}
	}

}
