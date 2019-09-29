import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("employee")
public class Employee {
	
	int id;
	String name;
	Address address;
	Date joiningDate;
	List<String> skills;
	boolean isActive;
	
	@Autowired
	public Employee() {
		
	}
	
	public Employee(int id, String name, Address address, Date joiningDate, List<String> skills,
			boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.joiningDate = joiningDate;
		this.skills = skills;
		this.isActive = isActive;
	}
	
	public Employee(Address address) {
		this.address=address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date date) {
		this.joiningDate = date;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
