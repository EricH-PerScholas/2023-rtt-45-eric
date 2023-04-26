package springexamples.database.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springexamples.database.entity.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeDAOTest {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void findAllWithOfficeNameTest() {
        employeeDAO.findAllWithOfficeName();
    }

    @Test
    public void findById() {
        Employee e = employeeDAO.findById(1002);

        Assertions.assertEquals(e.getFirstName(), "Diane");
        Assertions.assertEquals(e.getLastName(), "Murphy");
    }

    @Test
    @Order(0)
    public void createUser() {
        // given
        Employee given = new Employee();
        given.setEmail("test@test.com");
        given.setFirstName("John");
        given.setLastName("Doe");
        given.setJobTitle("Manager");
        given.setExtension("blah");
        given.setOfficeId(1);
        given.setReportsTo(1002);

        // when
        employeeDAO.save(given);

        // then
        Employee actual = employeeDAO.findByEmail("test@test.com");

        Assertions.assertEquals(given.getFirstName(), actual.getFirstName());
        Assertions.assertEquals(given.getLastName(), actual.getLastName());
        Assertions.assertEquals(given.getJobTitle(), actual.getJobTitle());
        Assertions.assertEquals(given.getReportsTo(), actual.getReportsTo());
    }

    @Test
    @Order(1)
    public void updateEmployeeTest() {
        // given
        Employee given = employeeDAO.findByEmail("test@test.com");

        given.setFirstName("Jane");
        given.setLastName("Doe");

        // when
        employeeDAO.save(given);

        Employee actual = employeeDAO.findByEmail("test@test.com");

        Assertions.assertEquals(given.getFirstName(), actual.getFirstName());
        Assertions.assertEquals(given.getLastName(), actual.getLastName());
    }

    @Test
    @Order(2)
    public void deleteEmployeeTest() {
        // given
        Employee given = employeeDAO.findByEmail("test@test.com");

        employeeDAO.delete(given);

        Employee actual = employeeDAO.findByEmail("test@test.com");
        Assertions.assertNull(actual);
    }

}
