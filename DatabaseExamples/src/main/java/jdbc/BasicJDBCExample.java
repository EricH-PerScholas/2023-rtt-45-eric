package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BasicJDBCExample {

	public static void main(String[] args) {
		String dburl = "jdbc:mysql://192.168.2.100:3306/classicmodels";
		String user = "dev";
		String password = "ultra30dev";
		
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		
		try {
			// create a new scanner and read the first name into the variable
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Enter a first name or a last name : ");
			String name = scan.nextLine();
			
			
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			
			String SelectSQL = "Select * FROM employees where firstName = ? or lastName = ?";
			
			// this is a JDBC class that creates the statement which will in turn run the SQL
			// using a prepared statement protects and prevents SQL Injection attacks
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			// this is 1 based so the first ? is #1
			stmt.setString(1,name);
			stmt.setString(2,name);

			// using the statement to execute a query and put the result into the ResultSet object
			ResultSet result = stmt.executeQuery();
			
			// loop over the result set.
			while (result.next()) {
				String EmployeeID = result.getString("employeeNumber");
				String fname = result.getString("firstName");
				String lname = result.getString("lastName");
				String email = result.getString("email");
				System.out.println(EmployeeID + " | " + fname + " | " + lname + " | " + email);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
}
