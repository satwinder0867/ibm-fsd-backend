package com.employeemgmt.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("employee")
public class Employee {
	String name;
	int age;
	int id;
	String designation;
	String department;
	String country;
	
	//@Autowired
	public Employee() {
		
	}
	
	public Employee(String name, int age,String department, String designation, String country) {
		super();
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.department = department;
		this.country = country;
	}
	
	
	public Employee(String name, int age, int id, String designation, String department, String country) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.designation = designation;
		this.department = department;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee name=" + name + ", age=" + age + ", id=" + id + ", designation=" + designation
				+ ", department=" + department + ", country=" + country ;
	}
	
	
}
