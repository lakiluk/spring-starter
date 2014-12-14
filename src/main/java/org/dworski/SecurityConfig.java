package org.dworski;

import org.dworski.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("org.dworski.service.auth")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;


    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().
                antMatchers("/login").permitAll().
                antMatchers("/logout").authenticated().
                antMatchers("/admin").access("hasRole('ADMIN')").
                antMatchers("/**").access("hasRole('ADMIN') or hasRole('USER')").and().
                formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").
                defaultSuccessUrl("/home").failureUrl("/login?error").and().rememberMe();
    }
}
