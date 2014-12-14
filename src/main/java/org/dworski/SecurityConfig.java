package org.dworski;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        builder.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().
                antMatchers("/", "/login", "/logout").permitAll().
                antMatchers("/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')").and().
                formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").
                defaultSuccessUrl("/home").failureUrl("/login?error").and().rememberMe();
    }
}
