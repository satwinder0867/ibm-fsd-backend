package com.examples.empapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.examples.empapp.dao.EmployeeDAO;
import com.examples.empapp.service.EmployeeService;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.examples.empapp")
public class CustomDispatcherConfig {
	
	@Bean
	public EmployeeService empService() {
		return new EmployeeService();
	}
	
	@Bean
	public EmployeeDAO empDao() {
		return new EmployeeDAO();
	}
	
//	@Bean
//	public MysqlDataSource dataSource() {
//		MysqlDataSource datasource = new MysqlDataSource();
//		datasource.setServerName("localhost");
//		datasource.setDatabaseName("jdbctraining");
//		datasource.setUser("training");
//		datasource.setPassword("training");
//		
//		return datasource;
//	}
	
	@Bean
	public Connection connection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctraining", "training", "training");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
