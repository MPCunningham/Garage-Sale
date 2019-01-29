/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.garagesale.config;

import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author macam
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Inject
    UserDetailsService userDetails;
    
    @Autowired
    public void configureGlobalInDB(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails).passwordEncoder(bCryptPasswordEncoder());
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/deleteuser", "/edituser").hasAnyAuthority("admin")

                    .antMatchers("/moderationpage").hasAnyAuthority("moderator","admin")
                    .antMatchers("/", "/Home", "/Register", "/createUser").permitAll()
                    .antMatchers("/css/**", "/js/**", "/fonts/**").permitAll()
                    .antMatchers("/CreateSale").permitAll()
                    .antMatchers("/creategaragesale").permitAll()
                    .antMatchers("/Garagesale").permitAll()



                .antMatchers("/ViewGarageSale").permitAll()

                    .antMatchers("/ViewGarageSale").permitAll()
                .antMatchers("/deleteItem").permitAll()
    
                    .antMatchers("/deleteGarageSale").permitAll()
                    .antMatchers("/editGarage").permitAll()
                    .antMatchers("/displayEditGarageSale").permitAll()
                    .antMatchers("/CreateItem").permitAll()


                    .anyRequest().hasRole("USER")

                    .anyRequest().hasRole("user")

                .and()
                    .formLogin()
                        .loginPage("/login")
                        .failureUrl("/login?login_error=1")
                        .permitAll()
                .successForwardUrl("/")
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                    .permitAll();
    }
}
