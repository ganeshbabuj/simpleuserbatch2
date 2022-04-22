package com.example.simpleuserbatch2.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties("batch.datasource")
    @Primary
    public DataSourceProperties batchDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "batchDataSource")
    @ConfigurationProperties("batch.datasource.configuration")
    @Primary
    public DataSource batchDataSource() {
        DataSource dataSource = batchDataSourceProperties().initializeDataSourceBuilder().build();
        return dataSource;
    }

    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSourceProperties appDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "appDataSource")
    @ConfigurationProperties("app.datasource.configuration")
    public DataSource appDataSource() {
        DataSource dataSource = appDataSourceProperties().initializeDataSourceBuilder().build();
        return dataSource;
    }

}
