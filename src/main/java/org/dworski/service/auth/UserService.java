package org.dworski.service.auth;

import org.dworski.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("userService")
public class UserService implements UserDetailsService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<User>();
        users.add(new User("admin", "admin", Arrays.<GrantedAuthority>asList(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("USER"))));
        users.add(new User("user", "user", Arrays.<GrantedAuthority>asList(new SimpleGrantedAuthority("USER"))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        throw new UsernameNotFoundException("Username " + username + " not found");
    }
}
