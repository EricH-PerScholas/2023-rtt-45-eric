package springexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.EmployeeDAO;
import springexamples.database.entity.Employee;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @RequestMapping(value = "/employee-search", method = RequestMethod.GET)
    public ModelAndView employeeSearch(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        log.info("In the employee search controller method with firstName = " + firstName + " lastName = " + lastName);

        ModelAndView response = new ModelAndView("employee/employee-search");

        // by this line of code we are assuming both are empty thus creating a new list with no search results
        // it has no results because there are no values coming.
        List<Employee> employees = new ArrayList<>();

        // check if both firstName and lastName have a value
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            // if so run the qurey that works with both values
            log.info("Both first name and last name have a value");
            employees = employeeDao.findByFirstNameContainingOrLastNameContainingIgnoreCase(firstName, lastName);
        }

        // check if the first name is not empty and the last name is empty
        if (!StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
            // we run our query that checks the fist name field only
            log.info("First name has a value and last name is empty");
            employees = employeeDao.findByFirstNameContainingIgnoreCase(firstName);
        }

        // check if the first name is empty and the last name is not empty
        if (StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            // we run our query that checks the last name field only
            log.info("Last name has a value and first name is empty");
            employees = employeeDao.findByLastNameContainingIgnoreCase(lastName);
        }


        response.addObject("employeesList", employees);
        response.addObject("searchParamFirst", firstName);
        response.addObject("searchParamLast", lastName);

        return response;
    }

}
