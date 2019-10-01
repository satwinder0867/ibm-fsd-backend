package com.employeemgmt.view;

import java.sql.Connection;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.employeemgmt.dao.DatabaseService;
import com.employeemgmt.model.Employee;
import com.employeemgmt.model.EmployeeConfiguration;
import com.employeemgmt.service.EmployeeService;

public class AppMain {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		EmployeeService eService = (EmployeeService) context.getBean("employeeService");
		DatabaseService dbService = (DatabaseService) context.getBean("databaseService");
		Connection conn = dbService.connect(); 
		dbService.setConn(conn);
		
		int choice;
		do {
			System.out.println("Enter 1 to add, 2 to view, 3 to update, 4 to delete, 5 to view all, 6 to import, 7 to export, 10 to exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					Employee e = takeInput();
					eService.addNewEmp(e);
					break;
				case 2:
					System.out.println("Enter Emp Id");
					int x= sc.nextInt();
					eService.view(x);
					break;
				case 3:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					e = takeInput();
					eService.update(x,e);
					break;
				case 4:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					eService.delete(x);
					break;
				case 5:
					eService.viewAllEmployees();
					break;
				case 6:
					eService.importEmployees();
					//importEmployeesUsingExecutor();
					break;
				case 7:
					eService.exportEmployees();
					break;
				case 10:
					System.out.println("Exiting...");
				default:
					System.out.println("Invalid entry please try again!!");
			}
			
			
		}while(choice!=10);
	}
	
	public static Employee takeInput() {
		System.out.println("Enter Name");
		String nName=sc.next();
		System.out.println("Enter Age");
		int nAge=sc.nextInt();
		System.out.println("Enter Designation");
		String nDesign=sc.next();
		System.out.println("Enter Department");
		String nDept=sc.next();
		System.out.println("Enter Country");
		String nCountry=sc.next();
		Employee newEmp = new Employee(nName, nAge, nDesign, nDept, nCountry);
		return newEmp;
	}

}
