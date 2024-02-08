package com.thinking.machines.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
	private List<String> employeesList;
	
	public Employees() {
		this.employeesList = new ArrayList();
	}
	
	public Employees(List<String> employeesList) {
		this.employeesList = employeesList;
	}
	
	public List<String> getEmployees() {
		return this.employeesList;
	}
	
	public void loadData() {
		// logic to read data from database and populate the list
		employeesList.add("Aishwary Adwani");
		employeesList.add("Chetan Malviya");
		employeesList.add("Saksham Solanki");
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> tempList = new ArrayList();
		for (String employee : this.employeesList) {
			tempList.add(employee);
		}
		
		return new Employees(tempList);
	}
}
