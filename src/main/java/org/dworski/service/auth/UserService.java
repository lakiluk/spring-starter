package org.dworski.service.auth;

import org.dworski.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
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

    @Autowired
    private SaltSource saltSource;

    public UserService() {
        users = new ArrayList<User>();
    }

    @PostConstruct
    public void init() {
        User user1 = new User("admin", Arrays.<GrantedAuthority>asList(new
                SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("USER")));
        user1.setPassword(createPassword(user1, "admin"));
        users.add(user1);

        User user2 = new User("user", Arrays.<GrantedAuthority>asList(new
                SimpleGrantedAuthority("USER")));
        user2.setPassword(createPassword(user2, "user"));
        users.add(user2);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        throw new UsernameNotFoundException("Username " + username + " not found");
    }

    private String createPassword(User user, String password) {
        Object salt = saltSource.getSalt(user);
        return passwordEncoder.encodePassword(password, salt);
    }
}
