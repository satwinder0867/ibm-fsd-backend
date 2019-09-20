package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {

	List<Employee> empList= new ArrayList<Employee>();
	
	public void addNewEmp() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Id : ");
		int Id=sc.nextInt();
		System.out.print("Enter Name : ");
		String Name=sc.next();
		System.out.print("Enter Age : ");
		int Age=sc.nextInt();
		System.out.print("Enter Designation : ");
		String Design=sc.next();
		System.out.print("Enter Department : ");
		String Dept=sc.next();
		System.out.print("Enter Country : ");
		String Country=sc.next();
		Employee newEmp = new Employee(Id,Name,Age, Design, Dept, Country);
		empList.add(newEmp);
		
	}

	public void viewEmp(int x) {
		try {
			if(x>empList.get(empList.size()-1).getId()) {
				throw new InvalidIdException("Enter valid id");
			}
			else {
				empList.forEach(e->{
					if(e.getId()==x) {
						System.out.println(e);
				}});
			}
		}
		catch(InvalidIdException e) {
			System.out.println(e.getMessage());
		}
	}
	

	public void updateEmp(int x) {
		try {
			if(x>empList.get(empList.size()-1).getId()) {
				throw new InvalidIdException("Enter valid id");
			}
			else {
				List<Employee> tempEmpList = new ArrayList<Employee>();
				empList.forEach(e-> {
					if(e.getId() != x) {
						tempEmpList.add(e);
					}
					else {
						System.out.println(e);
					}
				});
				empList=tempEmpList;
				addNewEmp();
			}
		}
		catch(InvalidIdException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteEmp(int x) {
		try {
			if(x>empList.get(empList.size()-1).getId()) {
				throw new InvalidIdException("Enter valid id");
			}
			else {
				List<Employee> tempEmpList = new ArrayList<Employee>();
				empList.forEach(e->{
					if(e.getId()!=x) {
						tempEmpList.add(e);
					}
				});
				empList=tempEmpList;
			}
		}
		catch(InvalidIdException e) {
			System.out.println(e.getMessage());
		}
	}

	public void viewAllEmp() {
		empList.forEach(e->{
			System.out.println(e);
		});
		
	}

	public void exportEmployees(List empList) throws InterruptedException {
		EmpExport e_Export = new EmpExport();
		e_Export.employeeList=empList;
		e_Export.start();
		e_Export.join();
		
	}
	public void importEmployees() throws InterruptedException {
		EmpImport e_import = new EmpImport();
		e_import.start();
		e_import.join();
		empList=e_import.employeeList;
	}

}
