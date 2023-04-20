package com.miit.training.inheritance;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miit.hibernateTraining.util.HibernateUtil;

public class TestTablePerHeirchy {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		PersonTablePerHeirchy person = new PersonTablePerHeirchy("Steve", "Balmer");
		session.save(person);

		EmployeeTablePerHeirchy employee = new EmployeeTablePerHeirchy("James", "Gosling", "Marketing", new Date());
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();

	}
}
