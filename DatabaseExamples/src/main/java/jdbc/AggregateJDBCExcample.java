package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AggregateJDBCExcample {

	public static void main(String[] args) {
		String dburl = "jdbc:mysql://192.168.2.100:3306/classicmodels";
		String user = "dev";
		String password = "ultra30dev";
		
		System.out.println("-------- MySQL JDBC Connection Demo ------------");
		
		try {
			// create a new scanner and read the first name into the variable
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Enter an amount : ");
			Integer amount = scan.nextInt();
			
			
			//Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			
			String SelectSQL = "select c.customerNumber, c.customerName, avg((MSRP - buyPrice)*quantityOrdered) as avg_margin "
					+ "from orders o, orderdetails od, products p, customers c "
					+ "where o.orderNumber = od.orderNumber "
					+ "and od.productCode = p.productCode "
					+ "and o.customerNumber = c.customerNumber "
					+ "group by c.customerNumber "
					+ "having avg((MSRP - buyPrice)*quantityOrdered) > ? "
					+ "order by avg_margin desc;";
			
			// this is a JDBC class that creates the statement which will in turn run the SQL
			// using a prepared statement protects and prevents SQL Injection attacks
			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			// this is 1 based so the first ? is #1
			stmt.setInt(1,amount);

			// using the statement to execute a query and put the result into the ResultSet object
			ResultSet result = stmt.executeQuery();
			
			// loop over the result set.
			while (result.next()) {
				String customerNumber = result.getString("customerNumber");
				String customerName = result.getString("customerName");
				String averageMargin = result.getString("avg_margin");
				System.out.println(customerNumber + ": " + averageMargin + " "  + customerName);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
