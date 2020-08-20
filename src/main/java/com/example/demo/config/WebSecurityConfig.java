package com.example.demo.config;

import com.example.demo.domain.service.AccountServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    private UserDetailsService service;

    @Autowired
    public WebSecurityConfig(final UserDetailsService service)
    {
        this.service = service;
    }
}