import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService {
	List<Employee> empList = new ArrayList<Employee>();
	public void getInput() {
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter 1 to add, 2 to view, 3 to update, 4 to delete, 5 to view all, 10 to exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					addNewEmp();
					break;
				case 2:
					System.out.println("Enter Emp Id");
					int x= sc.nextInt();
					view(x);
					break;
				case 3:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					update(x);
					break;
				case 4:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					delete(x);
					break;
				case 5:
					viewAll();
					break;
				case 10:
					System.out.println("Exiting...");
				default:
					System.out.println("Invalid entry please try again!!");
			}
			
			
		}while(choice!=10);
	}
	public void addNewEmp() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Id : ");
		int nId=sc.nextInt();
		System.out.print("Enter Name : ");
		String nName=sc.next();
		System.out.print("Enter Age : ");
		int nAge=sc.nextInt();
		System.out.print("Enter Designation : ");
		String nDesign=sc.next();
		System.out.print("Enter Department : ");
		String nDept=sc.next();
		System.out.print("Enter Country : ");
		String nCountry=sc.next();
		Employee newEmp = new Employee(nId, nName, nAge, nDesign, nDept, nCountry);
		empList.add(newEmp);
		
	}
	public void view(int x) {
		empList.forEach(e->{if(e.getId()==x) {
			System.out.println(e);
		}});
	}
	public void update(int x) {
		List<Employee> tempEmpList = new ArrayList<Employee>();
		empList.forEach(e->{
			if(e.getId()!=x) {
				tempEmpList.add(e);
			}
			else {
				System.out.println(e);
			}
		});
		empList=tempEmpList;
		addNewEmp();
			
		
		
	}
	public void delete(int x) {
		List<Employee> tempEmpList = new ArrayList<Employee>();
		empList.forEach(e->{
			if(e.getId()!=x) {
				tempEmpList.add(e);
			}
		});
		empList=tempEmpList;
	}
	public void viewAll() {
		empList.forEach(e->{
			System.out.println(e);
		});
	}
	
	

}
