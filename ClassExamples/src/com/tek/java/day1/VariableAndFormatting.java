package com.tek.java.day1;

// classnames are camel case with first letter upper case
// interfaces follow the same naming convention as a class name
public class VariableAndFormatting {

	/*
	 * Eclipse has a built in formatting tool. All members of the team must have the
	 * tool configured in the same way, otherwise you have a high probably of merge
	 * conflicts, not because the code has changed but because the formatting has
	 * changed
	 * 
	 * To use the built in formatting tool
	 * 
	 * 1) Ctrl a to select the entire file 2) Ctrl shift f - to format the file
	 * 
	 * this tool will also convert spaces to tabs within code indentation
	 */

	// constant is all letters uppercase with underscore seperating words.
	public static final String CONSTANT_VARIBLE_NAME = "Some string constant";

	// all variables are camel case with first letter lowercase
	public String someVariableName;

	// never use _ (underscore) in a variable name
	public String this_is_not_okay;

	// variable names can never start with a number
	// public String 1string;
	public String oneString;

	// variables can have a number in it .. they just cant start with a number
	public String oneString23;

	// the difference between a tab and a space is a tab is equal to 4 characters in
	// eclipse
	// however the tab and the space are 2 different characters
	// this one will be determined by the team you work with
	public String spaces = "    ";
	public String tab = "\t";

	// function names are same as variable names lowercase to start the name with
	// camel case for words
	// the curley braces up or down is also determined by the team
	public void functionName() {

	}

	// this is "wrong" unless the team agrees to do this
	public void functionWithBracesDown() {

	}

	// space before or after agruements
	public void functionParameterSpacing(String before, String after) {

	}
	
	/// boolean value set to true
	public boolean booleanValue = true;
	public int intValue = 55;
	public long longValue = 15032428723407524L;
	
	public Boolean booleanClass = true;
	public Integer intClass = 10;
	
	public void autoBox() {
		// this is an example of a depricated statement that should be avoided
		// not because its wrong or wont work but because it will eventually
		// be removed from the language.
		Integer i = new Integer(10);
	}
	
	// a string variable is defined with the ""
	public String utf8 = "¼";
	
	// a char is a single character that is defined with single quoote ''
	// the single quote is also referenced as a tic mark
	public char utf8Char = '¼';
	public char unicode = '\u00BC';
	
	int a = 5;
	int b = 5;
	public boolean test = ( a == b );  // this evaluates to true
	
	// in java the exclimation point ! means not
	public boolean test1 = ( a != b ); // this is equal to false 
	
	public void logicalOperators() {
		if ( a == b && a == 5) {
			// this is both a equals b and a equals 5
			// if either of these conditions is not true then the
			// code in this block will not execute
		}
		
		if ( a == 6 || b == 5 ) {
			// this code with execute if either codition is true
			// in this case a is not equal to 5 but b is equal to five
			// so the code in this block will execute
		}
		
		// this is going to increment the value of a by 1;
		// these 2 statements do the same thing
		a = a++;
		a = a + 1;
		
		for ( int x = 0 ; x <= 10 ; x++ ) {
			// the code inside here will execute 10 times and the value of x 
			// will increment by 1 each iteration through the loop
		}
		
		// this statement is trying to add an int and a long.  It is erroring
		// because it may not be able to store the result into an int
		// this is dangerous but we can cast the long to an int to make this compile
		// this just an example of type casting
		// adding int and double often requires typecasting the int to a double before adding
		long l = 10000;
		int m = 100;
		int n = (int)l + m;
		
		// not initialized - and not good practice
		// always initialize variables .. as we have done throught this file.
		int w;
	}

}
