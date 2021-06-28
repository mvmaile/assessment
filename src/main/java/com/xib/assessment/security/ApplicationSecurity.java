/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xib.assessment.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 *
 * @author maym
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter   {

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/agents").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/agents").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/teams").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/managers").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/v1/teams").permitAll()
                .and().httpBasic();
    }

}
