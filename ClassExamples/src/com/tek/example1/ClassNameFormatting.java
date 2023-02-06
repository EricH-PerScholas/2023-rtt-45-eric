package com.tek.example1;

// classnames are camel case with first letter upper case
// interfaces follow the same naming convention as a class name
public class ClassNameFormatting {

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
	public void functionWithBracesDown(String before, String after) {

	}

}
