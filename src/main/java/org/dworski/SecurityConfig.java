package org.dworski;

import org.dworski.service.auth.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(createDaoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider createDaoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setSaltSource(saltSource());
        provider.setUserDetailsService(userDetailsService());
        return provider;
    }


    @Bean
    public ShaPasswordEncoder passwordEncoder() {
        return new ShaPasswordEncoder(256);
    }

    @Bean
    public UserService userDetailsService() {
        return new UserService();
    }

    @Bean
    public ReflectionSaltSource saltSource() {
        ReflectionSaltSource reflectionSaltSource = new ReflectionSaltSource();
        reflectionSaltSource.setUserPropertyToUse("username");
        return reflectionSaltSource;
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
