package com.barnies.springboot.webapp.model;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource() {
    	
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/employee_manager")
                .username("username")
                .password("password")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
