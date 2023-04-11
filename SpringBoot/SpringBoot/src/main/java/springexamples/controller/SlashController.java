package springexamples.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springexamples.database.dao.UserDAO;
import springexamples.database.dao.UserRoleDAO;
import springexamples.database.entity.User;
import springexamples.database.entity.UserRole;
import springexamples.formbeans.CreateUserFormBean;
import springexamples.security.AuthenticatedUserService;

@Slf4j
@Controller
public class SlashController {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;


    @RequestMapping(value = { "/index", "/", "/index.html" }, method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {

        //log.debug("In the index controller method");
        ModelAndView response = new ModelAndView("index");

        log.debug("################# SESSION ATTRIBUTE NAME = " + session.getAttribute("name"));

        log.trace("This is a trace log example");
        log.debug("This is a debug log example");
        log.info("This is an info log example");
        log.warn("This is a warn log example");
        log.error("This is an error log example");

        return response;
    }

    @GetMapping("/signup")
    public ModelAndView setup(HttpSession session) {
        log.debug("In the signup controller method");
        ModelAndView response = new ModelAndView("signup");

        log.debug("Signup method in the controller is setting a value in the session");
        session.setAttribute("name", "signup set this value");

        return response;
    }

    @PostMapping("/signup")
    public ModelAndView setup(CreateUserFormBean form) {

        ModelAndView response = new ModelAndView("signup");
        log.debug("In the signup controller post method");

        // first we create our user
        User user = new User();
        user.setEmail(form.getEmail());
        user.setFullName(form.getFullName());

        // this is needed by spring security to encrypt passwords as the user is being created.
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        // save our user .. when hibernate saves this user it will auto generate PK
        // this line of code is doing 2 things .. saving the user to the database and populating the new PK id in the entity
        userDao.save(user);

        // create our user role object
        UserRole userRole = new UserRole();
        // we are going to hard code the default user role to be "USER"
        userRole.setRoleName("USER");
        // so when we go to set the user id FK on the user role entity the user id has been populated already.
        userRole.setUserId(user.getId());

        userRoleDao.save(userRole);

        // very important that this line of code is after both the user and the user role is saved to the database
        // authenticate the user that was just created
        authenticatedUserService.changeLoggedInUsername(form.getEmail(), form.getPassword());

        log.debug(form.toString());

        return response;
    }


    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public ModelAndView bootstrapExample(HttpSession session) {
        log.debug("In the bootstrap controller method");

        log.debug("Bootstrap method in the controller is setting a value in the session");
        session.setAttribute("name", "bootstrap set this value");
        ModelAndView response = new ModelAndView("bootstrap");
        return response;
    }



}
