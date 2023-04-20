package com.miit.training.inheritance;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miit.hibernateTraining.util.HibernateUtil;

public class TestTablePerSubClass {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		PersonTablePerSubClass person = new PersonTablePerSubClass("Steve", "Balmer");
		session.save(person);

		EmployeeTablePerSubClass employee = new EmployeeTablePerSubClass("James", "Gosling", "Marketing", new Date());
		session.save(employee);

		OwnerTablePerSubClass owner = new OwnerTablePerSubClass("Bill", "Gates", 300L, 20L);
		session.save(owner);

		
		session.getTransaction().commit();
		session.close();

	}
}
