 package com.javabykiran.SpringbootHibernateProject.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javabykiran.SpringbootHibernateProject.entities.Country;
import com.javabykiran.SpringbootHibernateProject.entities.Employee;
import com.javabykiran.SpringbootHibernateProject.entities.Registration;
import com.javabykiran.SpringbootHibernateProject.service.SpringService;
@CrossOrigin                           //Angular connection
@RestController
public class SpringController {

	@Autowired
	SpringService service;
	
	@RequestMapping("/getallemployee")
	public List<Employee>  listEmployee(){
		
		List<Employee> emplist=service.listEmployee();
		return emplist;
	}

// ====================================================================================

	@GetMapping("/getallcountry")
	public List<Country> getAllCountry(){
		List<Country> countrylist=service.getAllCountry();
		return countrylist;
		
	}
// ====================================================================================
	
	@GetMapping("/getemployeebyid/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		Employee emp=service.getEmployeeById(id);
	return emp;
	}
	
// ====================================================================================			
	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody Employee emp)
	{
	String result=service.addEmployee(emp);
	return result;
	}

// ====================================================================================

	@DeleteMapping("/deleteemployeebyid/{id}")
	public String deleteEmployeebyid(@PathVariable int id)
	{
	String result=service.deleteEmployeebyid(id);
	return result;
	}

// ====================================================================================
	
	@PutMapping("/updateemployee")
			public String updateEmployee(@RequestBody Employee employee)
			{
			String result=service.updateEmployee(employee);
			return result;
			}
	
// ====================================================================================
	@PostMapping("/logincheck")
	public HashMap  loginCheck(@RequestBody Registration reg){
		HashMap result=service.loginCheck(reg.getEmail(),reg.getPassword());
		return result;
		
	}

// ====================================================================================
	@RequestMapping("/getregisteredusers")
	public  List<Registration> listOfRegisteredUsers(){
		
		List<Registration> regList =service.listOfRegisteredUsers();
	return regList;	
	}
	}