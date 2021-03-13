package com.javabykiran.SpringbootHibernateProject.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabykiran.SpringbootHibernateProject.entities.Country;
import com.javabykiran.SpringbootHibernateProject.entities.Employee;
import com.javabykiran.SpringbootHibernateProject.entities.Registration;

@Repository
public class SpringDao {

	@Autowired
	SessionFactory sf;
	
	public List<Employee> listEmployee() {
		 
	Session session=sf.openSession();
//	Criteria criteria=session.createCriteria(Employee.class);
//	List<Employee> emplist=criteria.list();
	Query query=session.createQuery("From Employee ORDER BY id");
	List<Employee> emplist=query.getResultList();
	
		return emplist;
	}

// ====================================================================================

	// Save API
	public String addEmployee(Employee emp) {
		
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		Long millies=System.currentTimeMillis();
		Date  date=new Date(millies);
		System.out.println(date);
		emp.setCreateddtm(date);
		emp.setUpdateddtm(date);
		session.save(emp);
		transaction.commit();
		return "Employee Inserted Successfully";
	}
// ====================================================================================

// Delete API
	public String deleteEmployeebyid(int id) {
		System.out.println("Id"+id);
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query query=session.createQuery("delete from Employee where id=:id");
		
		query.setParameter("id",id);
		
		int i=query.executeUpdate();
		transaction.commit();
		
		if(i>0)
		{
		return "Employee deleted Succefully";
		}
		else
		{
		return "Something Went wrong";
		}
	}
// ====================================================================================

	public String updateEmployee(Employee employee) {
		
		int id=employee.getId();
		
		System.out.println(employee.getName());
		
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		Long millies=System.currentTimeMillis();
		Date  date=new Date(millies);
		System.out.println(date);
		employee.setCreateddtm(date);
		employee.setUpdateddtm(date);
		Query query=session.createQuery("update Employee set name=:name,email=:email,departmentit=:departmentit,status=:status,createddtm=:createddtm,createdby=:createdby,updateddtm=:updateddtm,updatedby=:updatedby,country=:country where id=:id ");
		query.setParameter("name", employee.getName());
		query.setParameter("email", employee.getEmail());
		query.setParameter("departmentit", employee.getDepartmentit());
		query.setParameter("status", employee.getStatus());
		query.setParameter("createddtm", employee.getCreateddtm());
		query.setParameter("createdby", employee.getCreatedby());
		query.setParameter("updateddtm", employee.getUpdateddtm());
		query.setParameter("updatedby", employee.getUpdatedby());
		query.setParameter("country", employee.getCountry());
		query.setParameter("id", employee.getId());

		int i=query.executeUpdate();
		transaction.commit();
		if(i>0)
		{
		return "Employee "+id+" Updated Successfully!";
		}
		else
		{
		return "Something went Wrong!";
		}

	}
// ====================================================================================

	public Registration loginCheck(String email, String password) {
	Session session=sf.openSession();
	Criteria cr=session.createCriteria(Registration.class);
	cr.add(Restrictions.eq("email",email));
	cr.add(Restrictions.eq("password",password));
	/*Criterion emailid=Restrictions.eq("email",email);
	Criterion pwd=Restrictions.eq("password",password);
	
	 LogicalExpression exp=Restrictions.and(emailid, pwd);
	 cr.add(exp);*/
	 
	 Registration regi=(Registration)cr.uniqueResult();
		return regi;
	}

// ====================================================================================
	
	public List<Registration> listOfRegisteredUsers() {
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Registration.class);
		
		List<Registration> regList=cr.list();
		return regList;
	}
// ====================================================================================	

	public List<Country> getAllCountry() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Country.class);
		List<Country> countrylist=criteria.list();
		
			return countrylist;
	
	}

	public Employee getEmployeeById(int id) {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		Employee emp=(Employee) criteria.uniqueResult();
		return emp;
	}
	
}
