package com.mamoni.tutorials.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mamoni.tutorials.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public int insertRow(Employee employee) throws Exception{
		int id = 0;
		Session session = null;
		Transaction trx = null;
		try{
			session = sessionFactory.openSession();
			trx = (Transaction)session.beginTransaction();			
			session.saveOrUpdate(employee);
			trx.commit();
			Serializable sid = session.getIdentifier(employee);			
			id = (Integer)sid;
		}catch(Exception ex){
			if(trx!=null){
				trx.rollback();				
			}
		}
			return id;
	}

	public List<Employee> getList() throws Exception{
		List<Employee> employeeList = new ArrayList<Employee>();
		Session session = null;
		Transaction trx = null;
		try{
			session = sessionFactory.openSession();
			trx = (Transaction)session.beginTransaction();			
			employeeList = (List<Employee>)session.createQuery("from Employee").list();
			//System.out.println("Getting Employee list in dao ");
			for(Employee emp:employeeList){
				//System.out.println("Employee name: " + emp.getFirstName());
			}
			trx.commit();			
		}catch(Exception ex){
			 ex.printStackTrace();
			
			if(trx!=null){
				trx.rollback();				
			}
		}
		return employeeList;
	}

	public Employee getRowById(int id) throws Exception{
		Employee employee = null;
		Session session = null;
		Transaction trx = null;
		try{
			session = sessionFactory.openSession();
			trx = (Transaction)session.beginTransaction();			
			employee = (Employee)session.load(Employee.class,id);			
			trx.commit();			
		}catch(Exception ex){
			if(trx!=null){
				trx.rollback();				
			}
		}
		return employee;
	}

	public int updateRow(Employee employee) throws Exception{
		int id = 0;
		Session session = null;
		Transaction trx = null;
		try{
			session = sessionFactory.openSession();
			trx = (Transaction)session.beginTransaction();			
			session.saveOrUpdate(employee);
			trx.commit();
			Serializable sid = session.getIdentifier(employee);			
			id = (Integer)sid;
		}catch(Exception ex){
			if(trx!=null){
				trx.rollback();				
			}
		}
			return id;
	}

	public int deleteRow(int id) throws Exception{
		int ids = 0;
		Employee employee = null;
		Session session = null;
		Transaction trx = null;
		try{
			session = sessionFactory.openSession();
			trx = (Transaction)session.beginTransaction();			
			employee = (Employee)session.load(Employee.class,id);	
			session.delete(employee);
			trx.commit();	
			Serializable sid = session.getIdentifier(employee);			
			ids = (Integer)sid;
		}catch(Exception ex){
			if(trx!=null){
				trx.rollback();				
			}
		}
		return ids;
	}

}
