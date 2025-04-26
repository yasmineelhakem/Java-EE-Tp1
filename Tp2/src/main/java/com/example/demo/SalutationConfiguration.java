package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class SalutationConfiguration {
    @Autowired
    DataBaseConfiguration dataBaseConfiguration;

    @Bean
    @Scope(value = "prototype")
    public Salutation salutation() {
        return new Salutation();
    }
    @Bean
    @Scope
    public SalutationAmicale salutationAmicale() {
        return new SalutationAmicale(dataBaseConfiguration) ;
    }
}
