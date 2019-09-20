package employee;

import java.util.*;
import java.util.Scanner;

public class EmpMain {
	
	public static void main(String[] args) throws InterruptedException
	{
		List<Employee> empList = new ArrayList<Employee>();
		EmployeeService e=new EmployeeService();
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
		System.out.println("Enter 1 : add || 2 : view || 3 : update || 4 : delete || 5 : view all || 6 : import || 7 : export || 10 : exit");
		choice = sc.nextInt();
		switch(choice) {
			case 1:
				e.addNewEmp();
				break;
			case 2:
				System.out.println("Enter Emp Id");
				int x= sc.nextInt();
				e.viewEmp(x);
				break;
			case 3:
				System.out.println("Enter Emp Id");
				x= sc.nextInt();
				e.updateEmp(x);
				break;
			case 4:
				System.out.println("Enter Emp Id");
				x= sc.nextInt();
				e.deleteEmp(x);
				break;
			case 5:
				e.viewAllEmp();
				break;
			case 6:
				e.importEmployees();
				break;
			case 7:
				e.exportEmployees(empList);
				break;
			case 10:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid entry please try again!!");
		}
		
		
	}while(choice!=10);
}
}