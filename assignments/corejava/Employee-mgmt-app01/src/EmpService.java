import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class EmpService {
	List<Employee> empList = new ArrayList<Employee>();
//	public void getInput() {
		
	public void importFromFile() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\SatwinderSingh\\Desktop\\userInput.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] arr = new String[10];
				arr = line.split(" ");
				for(int i=0;i<arr.length;i++)
				{
					
				}
				Employee e=new Employee();
				e.setId(Integer.parseInt(arr[0]));
				e.setName(arr[1]);
				e.setAge(Integer.parseInt(arr[2]));
				e.setDesign(arr[3]);
				e.setDept(arr[4]);
				e.setCountry(arr[5]);
				empList.add(e);
				
				//System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  
	}
	
	public void exportToFile() {
//		EmployeeExport e_Export = new EmployeeExport();
		EmpService e_Service = new EmpService();
		File file = new File("C:\\Users\\SatwinderSingh\\Desktop\\userExport.txt");
		FileWriter fr;
		try {
			fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter pr = new PrintWriter(br);
			empList.forEach(e -> {
			String line = e.getId()+","+e.getName()+","+e.getAge()+","+e.getDesign()+","+e.getDept()+","+e.getCountry();
			System.out.println(line);
			pr.println(line);
		});
			pr.close();
			br.close();
			fr.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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
