package com.mamoni.tutorials.dao;

import java.util.List;

import com.mamoni.tutorials.model.Employee;

public interface EmployeeDAO {
	
	 public int insertRow(Employee employee) throws Exception;  
	  
	 public List<Employee> getList() throws Exception;  
	  
	 public Employee getRowById(int id) throws Exception;  
	  
	 public int updateRow(Employee employee) throws Exception;  
	  
	 public int deleteRow(int id) throws Exception;  

}
