package org.dworski.service.auth;

import org.dworski.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("userService")
public class UserService implements UserDetailsService {

    private List<User> users;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    public UserService() {
        users = new ArrayList<User>();
    }

    @PostConstruct
    public void init() {
        users.add(new User("admin", passwordEncoder.encodePassword("admin", null), Arrays.<GrantedAuthority>asList(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("USER"))));
        users.add(new User("user", passwordEncoder.encodePassword("user", null), Arrays.<GrantedAuthority>asList(new SimpleGrantedAuthority("USER"))));
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
