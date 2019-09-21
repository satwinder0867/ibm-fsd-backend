package employeeApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImport extends Thread{
	//EmployeeService es = new EmployeeService();
	List<Employee> employeeList = new ArrayList<Employee>();
	public void run() {
		System.out.println("started import");
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src/employeeApp/employeeData.txt"));
			String line = reader.readLine();
			while (line != null) {
				String[] arr = new String[10];
				arr = line.split(",");
				Employee e = new Employee();
				e.setId(Integer.parseInt(arr[0]));
				e.setName(arr[1]);
				e.setAge(Integer.parseInt(arr[2]));
				e.setDesign(arr[3]);
				e.setDept(arr[4]);
				e.setCountry(arr[5]);
				employeeList.add(e);
				//System.out.println(employeeList);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("import complete");
	}
}