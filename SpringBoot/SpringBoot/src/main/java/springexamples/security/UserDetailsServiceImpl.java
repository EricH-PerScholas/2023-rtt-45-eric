package springexamples.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springexamples.database.dao.UserDAO;
import springexamples.database.dao.UserRoleDAO;
import springexamples.database.entity.User;
import springexamples.database.entity.UserRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRolesDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByEmail(username);

        // this first checks if the user is not found in the database (if it was found the user object would be not null)
        // UsernameNotFoundException is part of Spring Security and tell spring that the use was not found
        // it also stops the code from executing any further
        if (user == null) {
            throw new UsernameNotFoundException("Username '" + username + "' not found in database");
        }

        // these are used for advanced authentication features that we are not going to use
        boolean accountIsEnabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        // load the user roles from the database by the userid ( which we queried above by the username )
        List<UserRole> userRoles = userRolesDao.findByUserId(user.getId());

        // create the spring security user roles based on the ones we queried from the database
        // this is authorization part of spring security which allows some users access to secured parts of the application
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        // return a spring security user object that contains all of the information we gathered, it will be used
        // by spring security to determine if the authentication is successful
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                            accountIsEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, springRoles);

    }

    private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserRole role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }
}
