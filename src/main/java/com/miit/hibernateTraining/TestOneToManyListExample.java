package com.miit.hibernateTraining;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miit.hibernateTraining.util.HibernateUtil;

public class TestOneToManyListExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Department department = new Department();
		department.setDepartmentName("Sales");

		Employee emp1 = new Employee("Nina", "Mayers", "111");
		Employee emp2 = new Employee("Tony", "Almeida", "222");
		
		department.setEmployees(new ArrayList<Employee>());
		department.getEmployees().add(emp1);
		department.getEmployees().add(emp2);
		
		session.save(department);

		session.getTransaction().commit();
		session.close();
	}
}
