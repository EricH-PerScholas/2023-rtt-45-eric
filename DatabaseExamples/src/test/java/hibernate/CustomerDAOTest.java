package hibernate;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;


public class CustomerDAOTest {
	
	private static CustomerDAO customerDao;
	
	@BeforeAll
	public static void setUp() {
		customerDao = new CustomerDAO();
	}


	@Test
	public void findByIdTest() {
		
		// given
		Customer expected = new Customer();
		expected.setCustomerName("Atelier graphique");
		expected.setContactLastname("Schmitt");
		expected.setContactFirstname("Carine");
		
		// when
		Customer actual = customerDao.findById(103);
		
		// then
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstname(), actual.getContactFirstname());
		Assertions.assertEquals(expected.getContactLastname(), actual.getContactLastname());
	}
	
	@ParameterizedTest
	@CsvSource({
		"103,Atelier graphique,Schmitt,Carine",
		"112,Signal Gift Stores,King,Jean"
	})
	public void findByIdParameterizedTest(ArgumentsAccessor args) {
		
		// given
		Customer expected = new Customer();
		expected.setCustomerName(args.getString(1));
		expected.setContactLastname(args.getString(2));
		expected.setContactFirstname(args.getString(3));
		
		// when
		Customer actual = customerDao.findById(args.getInteger(0));
		
		// then
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactFirstname(), actual.getContactFirstname());
		Assertions.assertEquals(expected.getContactLastname(), actual.getContactLastname());
	}
	
	@Test
	public void checkinTest() {
		 
		// given
		// MoveRental recrod with the correct values set
		
		// when
		// query for the user
		// query for the movie
		// run the checkin function returns the movie record that was created
		
		// then
		// assert the movie record = expected
	}
}
