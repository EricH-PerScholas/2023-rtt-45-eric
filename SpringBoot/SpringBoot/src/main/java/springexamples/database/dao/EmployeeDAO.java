package springexamples.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springexamples.database.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    // this is a JPA hibernate query
    @Query("FROM Employee e")
    List<Employee> getAllEmployees();

    List<Employee> findByFirstNameContainingOrLastNameContainingIgnoreCase(String firstName, String lastName);

    @Query(value="select * from employees where lower(firstname) = lower(:firstName);", nativeQuery = true)
    List<Employee> usingNativeQuery(String firstName, String lastName);

    @Query("Select e from Employee e where lower(e.firstName) = lower(:firstName)")
    List<Employee> usingJPAQuery(String firstName, String lastName);
}