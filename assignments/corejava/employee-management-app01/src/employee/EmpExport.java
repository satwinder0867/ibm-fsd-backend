package employee;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EmpExport  extends Thread{
	List<Employee> employeeList = new ArrayList<Employee>();
	public void run() {
		EmployeeService e_Service = new EmployeeService();
		//String line = "";
		File file = new File("src/employee/userOutput.txt");
		FileWriter fr;
		try {
			fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter pr = new PrintWriter(br);
			employeeList.forEach(e -> {
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
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
}