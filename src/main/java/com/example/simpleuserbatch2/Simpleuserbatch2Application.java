package com.example.simpleuserbatch2;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.net.MalformedURLException;

@SpringBootApplication
public class Simpleuserbatch2Application {

	public static void main(String[] args) {
		SpringApplication.run(Simpleuserbatch2Application.class, args);
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("appDataSource") DataSource dataSource) throws MalformedURLException {

		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("schema.sql"));
		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator);

		return initializer;
	}

}
