package com.stream.test;

import java.util.List;
import java.util.stream.Collectors;

import com.stream.dto.Employee;

public class Demo2CollectorSumAverage {

	public static void main(String[] args) {
		List<Employee> employees = List.of(
				new Employee(1, "Raghav", 75000.98, "EMT4", List.of("Java", "Neo4j", "Powershell")),
				new Employee(2, "Nithya", 95000.98, "ETC", List.of("SalesForce", "JavaScript", "Powershell")),
				new Employee(3, "Arun", 85000.98, "EMT5", List.of("SalesForce", "JDBC", "SalesCloud")),
				new Employee(4, "Milank", 76000.98, "EMT4", List.of("Java", "Spring", "AWS")),
				new Employee(5, "Chethan", 77000.98, "EMT4", List.of("Spring", "Neo4j", "Powershell"))
				);
		
//		Average Salary of all the employees
		employees.stream()
				.mapToDouble(emp-> emp.getSalary()).average();
		double averageSalaryAllEmployees = employees.stream()
				.collect(Collectors.averagingDouble(emp -> emp.getSalary()));
		System.out.println("AveragingDouble:: " + averageSalaryAllEmployees);
		
//		Average salary of EMT$ department
		double emt4Salary = employees.stream()
		.filter(emp -> emp.getDepartment().equals("EMT4"))
		.collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("AveragingDouble EMT4 Salary:: " + emt4Salary);
//	    Average salary of person who earn more than 80k
		double highSalaryAverage = employees.stream()
		.filter(emp -> emp.getSalary() > 80000)
		.collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("AveragingDouble High Salary Average :: " + highSalaryAverage);
//		Average bonus of employees (10% salary)
		double bonusAverage = employees.stream()
				.collect(Collectors.averagingDouble(emp -> emp.getSalary() * 0.01));
		System.out.println("AveragingDouble Bonus Average :: " + bonusAverage);
//     Average skill count
		double averageSkillCount = employees.stream()
		.collect(Collectors.averagingDouble(emp -> emp.getSkills().size()));
		System.out.println("averageSkillCount :: " + averageSkillCount);
//		Average training cost of all skills if 1 skill cost is 2000
		double averageTrainingCost = employees.stream()
		.collect(Collectors.averagingDouble(emp -> emp.getSkills().size() * 2000));
		System.out.println("averageTrainingCost :: " + averageTrainingCost);

		


	}

}
