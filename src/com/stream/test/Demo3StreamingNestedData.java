package com.stream.test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.stream.dto.Employee;

public class Demo3StreamingNestedData {

	public static void main(String[] args) {
		List<Employee> employees = List.of(
				new Employee(1, "Raghav", 75000.98, "EMT4", List.of("Java", "Neo4j", "Powershell")),
				new Employee(2, "Nithya", 95000.98, "ETC", List.of("SalesForce", "JavaScript", "Powershell")),
				new Employee(3, "Arun", 85000.98, "EMT5", List.of("SalesForce", "JDBC", "SalesCloud")),
				new Employee(4, "Milank", 76000.98, "EMT4", List.of("Java", "Spring", "AWS")),
				new Employee(5, "Chethan", 77000.98, "EMT4", List.of("Spring", "Neo4j", "Powershell"))
				);

		//		Get All distinct skills
		Set<String> distinctSkills =  employees.stream()
		.map(emp -> emp.getSkills())
		.flatMap(skills -> skills.stream())
		//						.distinct()
		//						.forEach(System.out::println);;
		.collect(Collectors.toSet());
		System.out.println(distinctSkills);
		distinctSkills = employees.stream()
		.collect(Collectors.flatMapping(emp-> emp.getSkills().stream(), Collectors.toSet()));
		System.out.println(distinctSkills);

		System.out.println();

//		Get the employee with highest salary
		/*The follwoing code takes the maximum salary field entry not entire object */
		Optional<Double> maxSalaryOpt = employees.stream()
		.map(emp -> emp.getSalary())
		.max((e1,e2) -> e1.compareTo(e2));
		System.out.println("Max Salary is : " + maxSalaryOpt.get());
		
		/*The follwoing code takes the maximumsalary object */
		Optional<Employee> maxSalaryEmpOpt = employees.stream()
				.collect(Collectors.maxBy((e1,e2)-> Double.compare(e1.getSalary(), e2.getSalary())));
		System.out.println("Max Salary earned Employee is : " + maxSalaryEmpOpt.get());
		System.out.println();

//		Get the employee with lowest salary
		Optional<Employee> minSalaryEmpOpt =employees.stream()
		.collect(Collectors.minBy(Comparator.comparing(Employee::getSalary)));
		System.out.println("Min Salary earned Employee is : " + minSalaryEmpOpt.get());
		System.out.println();
		
		
		
		
 



	}

}
