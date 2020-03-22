package com.cognizant.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.cognizant")
@PropertySource(value = { "classpath:db.properties" })
public class ApplicationConfig {
	@Autowired
	private Environment environment;

	@Bean
	public DataSource getDataSourceBean() {

		DriverManagerDataSource ds = new DriverManagerDataSource();

		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/studentdetails");
		ds.setUsername("root");
		ds.setPassword("root123");

		return ds;

	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		JdbcTemplate jt = new JdbcTemplate(ds);
		return jt;

	}

	@Bean("studao")
	public StudentDao stdentDao() {
		return new StudentDaoImpl();
	}
}
