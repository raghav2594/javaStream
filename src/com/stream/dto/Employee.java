package com.stream.dto;

import java.util.List;

public class Employee {

	private int id;
	private String name;
	private double salary;
	private String department;
	private List<String> skills;
	
	
	public Employee(int id, String name, double salary, String department, List<String> skills) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.skills = skills;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", skills=" + skills + "]";
	}
	
	
	
	
}
