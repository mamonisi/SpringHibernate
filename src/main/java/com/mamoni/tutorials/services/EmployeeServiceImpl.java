package com.mamoni.tutorials.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mamoni.tutorials.dao.EmployeeDAO;
import com.mamoni.tutorials.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;

	public int insertRow(Employee employee) {
		int id = 0;
		try{
			id =  employeeDao.insertRow(employee);
		}catch(Exception e){
			System.out.println("Insert Employee failed : " + e);
		}
		return id;
	}

	public List<Employee> getList() {
		List<Employee> employeeList = new ArrayList<Employee>();
		try{
			employeeList = employeeDao.getList();
			//System.out.println("After getting employee list in EmployeeService");
		}catch(Exception e){
			System.out.println("Get Employee list failed : " + e);
		}
		return employeeList;
	}

	public Employee getRowById(int id) {
		Employee employee = null;
		try{
			employee = employeeDao.getRowById(id);
		}catch(Exception e){
			System.out.println("Get Employee with id failed : " + e);
		}
		return employee;
	}

	public int updateRow(Employee employee) {
		int id = 0;
		try{
			id =  employeeDao.updateRow(employee);
		}catch(Exception e){
			System.out.println("Update Employee failed : " + e);
		}
		return id;
	}

	public int deleteRow(int id) {
		int sid = 0;
		try{
			sid =  employeeDao.deleteRow(id);
		}catch(Exception e){
			System.out.println("Delete Employee failed : " + e);
		}
		return sid;
	}

}
