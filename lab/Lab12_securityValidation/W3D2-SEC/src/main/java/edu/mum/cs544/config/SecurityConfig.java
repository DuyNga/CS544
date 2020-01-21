package edu.mum.cs544.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}123").roles("USER","ADMIN").and()
                .withUser("user").password("{noop}bla").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests().antMatchers("/*").hasAnyRole("ADMIN", "USER").and()
                .authorizeRequests().antMatchers("/books/add").hasRole("ADMIN").and()
                .authorizeRequests().antMatchers(HttpMethod.POST).hasRole("ADMIN").and()
                .authorizeRequests().antMatchers("/books/**").hasRole("ADMIN").and()
                .formLogin().and()
                .logout();
    }
}