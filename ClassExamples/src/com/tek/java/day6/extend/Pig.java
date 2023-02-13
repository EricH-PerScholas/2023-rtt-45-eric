package com.tek.java.day6.extend;

public class Pig extends Animal {

	@Override
	public void animalSound() {
		System.out.println("This pig makes the sound oink oink");
	}
	
	public void anotherMethod() {
		System.out.println("Pig extra method");
	}
}
