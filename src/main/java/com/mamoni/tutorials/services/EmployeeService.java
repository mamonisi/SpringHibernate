package com.mamoni.tutorials.services;

import java.util.List;

import com.mamoni.tutorials.model.Employee;

public interface EmployeeService {
	
	 public int insertRow(Employee employee);  
	  
	 public List<Employee> getList();  
	  
	 public Employee getRowById(int id);  
	  
	 public int updateRow(Employee employee);  
	  
	 public int deleteRow(int id);  
	  
	

}
