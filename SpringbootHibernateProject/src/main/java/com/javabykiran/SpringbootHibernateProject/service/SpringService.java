package com.javabykiran.SpringbootHibernateProject.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabykiran.SpringbootHibernateProject.dao.SpringDao;
import com.javabykiran.SpringbootHibernateProject.entities.Country;
import com.javabykiran.SpringbootHibernateProject.entities.Employee;
import com.javabykiran.SpringbootHibernateProject.entities.Registration;

@Service
public class SpringService {

	@Autowired
	SpringDao springdao;

	public List<Employee> listEmployee() {
		List<Employee> emplist=springdao.listEmployee();
		return emplist;
	}
// ====================================================================================

// Save API
	public String addEmployee(Employee emp) {
		String result=springdao.addEmployee(emp);
		return result;
	}

// ====================================================================================

// Delete API
	public String deleteEmployeebyid(int id) {
		String result=springdao.deleteEmployeebyid(id);
		return result;
		}

// ====================================================================================
	
	
// Update API	

	public String updateEmployee(Employee employee) {
		String result=springdao.updateEmployee(employee);
		return result;
		}
// ====================================================================================

	public HashMap loginCheck(String email, String password) {
		HashMap map=new HashMap<>();
		
		Registration reg =springdao.loginCheck(email,password);
		if (reg==null){
			map.put("msg", "Invalid User");
		}else{
			map.put("msg", "Valid User");
			reg.setPassword("********");
			map.put("user", reg);
		}
		return map;
	}
// ====================================================================================
	
	public List<Registration> listOfRegisteredUsers() {
		List<Registration> regList=springdao.listOfRegisteredUsers();
		return regList;
	}
// ====================================================================================
	
	public  List<Country> getAllCountry() {
		List<Country> countrylist=springdao.getAllCountry();
		return countrylist;
	}
// ====================================================================================

	public Employee getEmployeeById(int id) {
		Employee emp=springdao.getEmployeeById(id);
		return emp;
	}

// ====================================================================================
		
}
