package com.employeemgmt.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeemgmt.dao.DatabaseService;
import com.employeemgmt.model.Employee;

@Component()
public class EmployeeService {
	
	DatabaseService db_Service = new DatabaseService();
	List<Employee> employeeList = new ArrayList<Employee>();
	public EmployeeService(Employee employee) {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public EmployeeService() {
		
	}

	public void viewAllEmployees() {
			ResultSet rs = db_Service.getAllEmployee();
			
			try {
				while (rs.next()) {
					// Retrieve by column name
					int id = rs.getInt("id");
					int age = rs.getInt("age");
					String name = rs.getString("name");
					String designation = rs.getString("designation");
					String department = rs.getString("department");
					String country = rs.getString("country");

					// Display values
					System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s\n", id, age, name, designation, department, country);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	public void addNewEmp(Employee e) {
		int id = e.getId();
		int age = e.getAge();
		String name = e.getName();
		String department = e.getDepartment();
		String designation = e.getDesignation();
		String country = e.getCountry();
		db_Service.insertNewEmployee(id,age,name,department,designation,country);
	}

	public void view(int x) {
		Employee e = db_Service.findEmployee(x);
		System.out.println(e);
	}

	public void update(int x, Employee e) {
		int id = e.getId();
		int age = e.getAge();
		String name = e.getName();
		String department = e.getDepartment();
		String designation = e.getDesignation();
		String country = e.getCountry();
		db_Service.insertNewEmployeeAtPosition(id,age,name,department,designation,country,x);
	}

	public void delete(int x) {
		db_Service.deleteEmployeeFromDb(x);
		System.out.println("Employee deleted ...");
	}

	public void importEmployees() {
		System.out.println("started import");
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src/main/resources/employee_data.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] arr = new String[10];
				arr = line.split(",");
				Employee e = new Employee();
				e.setId(Integer.parseInt(arr[0]));
				e.setName(arr[1]);
				e.setAge(Integer.parseInt(arr[2]));
				e.setDesignation(arr[3]);
				e.setDepartment(arr[4]);
				e.setCountry(arr[5]);
				//System.out.println(e);
				addNewEmp(e);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("import complete");
	}

	public void exportEmployees() {
		//String line = "";
				File file = new File("src/main/resources/employee_data_out.txt");
				FileWriter fr;
				try {
					fr = new FileWriter(file, true);
					BufferedWriter br = new BufferedWriter(fr);
					PrintWriter pr = new PrintWriter(br);
					ResultSet rs = db_Service.getAllEmployee();
					
					try {
						while (rs.next()) {
							// Retrieve by column name
							int id = rs.getInt("id");
							int age = rs.getInt("age");
							String name = rs.getString("name");
							String designation = rs.getString("designation");
							String department = rs.getString("department");
							String country = rs.getString("country");
							
							Employee newEmp = new Employee(name, age,id,designation, department, country);
							employeeList.add(newEmp);
							// Display values
							//System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s\n", id, age, name, designation, department, country);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					employeeList.forEach(e -> {
						String line = e.getId()+","+e.getName()+","+e.getAge()+","+e.getDesignation()+","+e.getDepartment()+","+e.getCountry();
						//System.out.println(line);
						pr.println(line);
					});
					pr.close();
					br.close();
					fr.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	}

}
