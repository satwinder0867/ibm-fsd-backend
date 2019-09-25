package view;

import java.util.Scanner;

import dao.DbServices;
import services.EmployeeServices;
import view.Employee;

public class EmployeeMain {
	static Scanner sc=new Scanner(System.in);
	
	public static Employee takeInput() {
		System.out.println("Enter Id");
		int nId=sc.nextInt();
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
		Employee newEmp = new Employee(nId, nName, nAge, nDesign, nDept, nCountry);
		return newEmp;
	}

	public static void main(String[] args) {
		int choice;
		EmployeeServices e_Service = new EmployeeServices();
		//Db_Services db_service = new Db_Services();
		do {
			System.out.println("Enter 1 to add, 2 to view, 3 to update, 4 to delete, 5 to view all, 6 to import, 7 to export, 10 to exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					Employee e = takeInput();
					e_Service.addNewEmp(e);
					break;
				case 2:
					System.out.println("Enter Emp Id");
					int x= sc.nextInt();
					e_Service.view(x);
					break;
				case 3:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					e = takeInput();
					e_Service.update(x,e);
					break;
				case 4:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					e_Service.delete(x);
					break;
				case 5:
					e_Service.viewAllEmployees();
					break;
				case 6:
					e_Service.importEmployees();
					//importEmployeesUsingExecutor();
					break;
				case 7:
					e_Service.exportEmployees();
					break;
				case 10:
					System.out.println("Exiting...");
				default:
					System.out.println("Invalid entry please try again!!");
			}
			
			
		}while(choice!=10);
	}

}