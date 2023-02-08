package com.tek.java.day2;

public class Day2Part2 {

	public static void main(String[] args) {
		Day2Part2 d2 = new Day2Part2();

		// d2.ifStatement();
		d2.caseStatement();
	}

	public void caseStatement() {
		int menuSelection = 76;

		switch (menuSelection) {
			case 1: {
				System.out.println("Selection = 1");
				break;
			}
			case 2: {
				System.out.println("Selection = 2");
				break;
			}
			case 3: {
				System.out.println("Selection = 3");
				break;
			}
			default: { 
				System.out.println("This acts as the catch all bucket if no other conditions are met");
			}	
		}
		
	}

	public void ifStatement() {
		int grade = -5;

		// !!!!!!!!!!!!!!!! YOU MUST ALWAYS HAVE {} FOR THE CODE BLOACK AFTER THE IF
		// STATEMENT

		if (grade > 100 || grade < 0) {
			System.out.println("Grade " + grade + " is invalid");
			if (grade < 0) {
				System.out.println("The grade " + grade + " is negative");
			} else {
				System.out.println("The grade " + grade + " is positive");
			}
		} else if (grade >= 90) {
			System.out.println("Grade " + grade + " for the course is an A");

		} else if (grade >= 80) {
			System.out.println("Grade " + grade + " for the course is an B");

		} else if (grade >= 70) {
			System.out.println("Grade " + grade + " for the course is an C");

		} else if (grade >= 60) {
			System.out.println("Grade " + grade + " for the course is an D");

		} else {
			System.out.println("Grade " + grade + " for the course is an F");
		}

		System.out.println("This is executed after the if statement");
	}

}
