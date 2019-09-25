package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import view.Employee;

public class DbServices{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";

	// Database credentials
	static final String USER = "training";
	static final String PASS = "training";
	static Connection conn = null;
	public DbServices() {
		try {
			// STEP 2: Register JDBC driver with Driver Manager
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			//System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false); // enable transaction
			
			System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			//System.out.println("Creating statement...");
		}catch (Exception e) {
			
		}
	}
	
	Connection connect() {
		
		try {
			// STEP 2: Register JDBC driver with Driver Manager
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			//System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false); // enable transaction

			//System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			//System.out.println("Creating statement...");
		}catch (Exception e) {
			
		}
		return conn;
	}
	
	public ResultSet getAllEmployee() {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String selectQuery = "select * from employee";
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public void insertNewEmployee(int id, int age, String name, String department, String designation, String country) {
		String insertQuery = "INSERT INTO employee (id,name, age, designation, department, country)" +"VALUES (?,?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement ps = conn.prepareStatement(insertQuery);
			ps.setInt(1, id);
			ps.setString(3, name);
			ps.setInt(2, age);
			ps.setString(4, designation);
			ps.setString(5, department);
			ps.setString(6, country);
			ps.executeUpdate();
			ps.close();
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee findEmployee(int x) {
		Employee e = null;
		String findEmployeeQuery = "select * from employee where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(findEmployeeQuery);
			ps.setInt(1, x);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String name = rs.getString("name");
			String designation = rs.getString("designation");
			String department = rs.getString("department");
			String country = rs.getString("country");
			e=new Employee(id,name,age,designation,department,country);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	public void insertNewEmployeeAtPosition(int id, int age, String name, String department, String designation,
			String country, int x) {
		String insertQuery = "UPDATE employee SET name = ?,age = ?,designation = ?,department = ?,country = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(insertQuery);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, designation);
			ps.setString(4, department);
			ps.setString(5, country);
			ps.setInt(6, x);
			int i = ps.executeUpdate();
			ps.close();
			System.out.println(i);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteEmployeeFromDb(int x) {
		String deleteQuery = "DELETE FROM employee WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(deleteQuery);
			ps.setInt(1, x);
			int deleteCount = ps.executeUpdate();
			ps.close();
			System.out.println(deleteCount + " Employee(s) deleted");
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}