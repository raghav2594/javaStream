package com.stream.test;

import java.util.List;
import java.util.stream.Collectors;

import com.stream.dto.Employee;


public class Demo1CollectorsSumDouble {

	public static void main(String[] args) {

		List<Employee> employees = List.of(
				new Employee(1, "Raghav", 75000.98, "EMT4", List.of("Java", "Neo4j", "Powershell")),
				new Employee(2, "Nithya", 95000.98, "ETC", List.of("SalesForce", "JavaScript", "Powershell")),
				new Employee(3, "Arun", 85000.98, "EMT5", List.of("SalesForce", "JDBC", "SalesCloud")),
				new Employee(4, "Milank", 76000.98, "EMT4", List.of("Java", "Spring", "AWS")),
				new Employee(5, "Chethan", 77000.98, "EMT4", List.of("Spring", "Neo4j", "Powershell"))
				);

		//Collectors.SummingDouble
		//		Total Salary of all the employees:
		//Simple 1
		employees.stream()
		.mapToDouble(e -> e.getSalary()).sum();
		// case 2 with summing double
		double totalSalary = employees.stream()
				.collect(Collectors.summingDouble(employee -> employee.getSalary()));
		// case 3 with summing double with method reference
		employees.stream()
		.collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("SummingDouble of totalSalary:" + totalSalary);

		//      Total Salary of EMT4 department
		double emt4Salary = employees.stream()
				.filter(emp -> emp.getDepartment().equals("EMT4"))
				.collect(Collectors.summingDouble(emp -> emp.getSalary()));
		System.out.println("SummingDouble of EMT4 department totalSalary:" + emt4Salary);

		//		Total salary of Employees earning more than 80000
		double highSalaryTotal = employees.stream()
				.filter(emp -> emp.getSalary() > 8000)
				.collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("SummingDouble of above 80000 earning employee totalSalary:" + highSalaryTotal);

		//		Total number of skills across all employees
		int totalSkillCount = employees.stream()
				.collect(Collectors.summingInt(emp -> emp.getSkills().size()));
		System.out.println("SummingInt of total Number of skills:" + totalSkillCount);

		//		Total skills among ETC employee
		int etcSkillCount = employees.stream()
				.filter(emp -> emp.getDepartment().equals("ETC"))
				.collect(Collectors.summingInt(emp -> emp.getSkills().size()));
		System.out.println("SummingInt of total Number of skills of ETC:" + etcSkillCount);

		//      Total Bonus payout (10% of Salary)
		double totalBonus = employees.stream()
				.collect(Collectors.summingDouble(emp -> emp.getSalary() * 0.10));
		System.out.println("SummingDouble of total bonus:" + totalBonus);
		
//		Total training cost of all skills if 1 skill cost is 2000
		int totalTrainingCost = employees.stream()
		.collect(Collectors.summingInt(emp -> emp.getSkills().size() * 2000));
		System.out.println("SummingInt of total training cost:" + totalTrainingCost);






	}

}
