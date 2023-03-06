package hibernate;

public class OneToManyExample {
	
	// One to Many - https://attacomsian.com/blog/spring-data-jpa-one-to-many-mapping
	// Many to Many - https://attacomsian.com/blog/spring-data-jpa-many-to-many-mapping

	public static void main(String[] args) {
		CustomerDAO customerDao = new CustomerDAO();
		EmployeeDAO employeeDao = new EmployeeDAO();
		
		
		Employee e = employeeDao.findById(1166);
		System.out.println(e);
		
		for ( Customer customer : e.getCustomers() ) {
			System.out.println(customer);
		}
		
		
		Customer customer = new Customer();
		customer.setCustomerName("Hibernate customer 123444444444");
		customer.setContactFirstname("First Name");
		customer.setContactLastname("Last Name");
		customer.setPhone("555-555-1212");
		customer.setAddressLine1("Address Line 1");
		customer.setCity("Denver");
		customer.setState("CO");
		customer.setCountry("USA");	
		customer.setEmployee(e);
		
		//customerDao.insert(customer);
		
		e.getCustomers().add(customer);
		employeeDao.update(e);
	
	}
}
