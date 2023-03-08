package hibernate;

import java.util.Calendar;
import java.util.Date;

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
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -30);
		Date dateBefore30Days = cal.getTime();	
		
		System.out.println("is date before " + dateBefore30Days.before(dateBefore30Days));
		
		
		Payment p = new Payment();
		p.setAmount(50000.55);
		p.setPaymentDate(dateBefore30Days);
		p.setCustomer(customer);
		p.setCheckNumber("123455");
		
		customer.getPayments().add(p);
		customerDao.update(customer);
	
	}
}
