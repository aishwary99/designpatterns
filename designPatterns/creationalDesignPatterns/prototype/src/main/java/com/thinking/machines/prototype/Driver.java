package com.thinking.machines.prototype;

import java.util.List;

public class Driver {
	public static void main(String args[]) throws CloneNotSupportedException {
		Employees employees = new Employees();
		employees.loadData();
		
		//Use the clone method to get the Employee object
		Employees employeesOne = (Employees) employees.clone();
		Employees employeesTwo = (Employees) employees.clone();
		
		List<String> listOne = employeesOne.getEmployees();
		listOne.add("John");
		
		List<String> listTwo = employeesTwo.getEmployees();
		listTwo.remove("Pankaj");
		
		System.out.println("Employees List : " + employees.getEmployees());
		
		System.out.println("EmployeesOne List: " + listOne);
		
		System.out.println("EmployeesTwo List: " + listTwo);
	}
}
