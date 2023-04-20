package com.miit.training.inheritance;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.miit.hibernateTraining.util.HibernateUtil;

public class TestTablePerConcreteClass {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		PersonTablePerConcreteClass person = new PersonTablePerConcreteClass("Steve", "Balmer");
		person.setPersonId(1L);
		session.save(person);

		EmployeeTablePerConcreteClass employee = new EmployeeTablePerConcreteClass("James", "Gosling", "Marketing", new Date());
		employee.setPersonId(2L);
		session.save(employee);

		OwnerTablePerConcreteClass owner = new OwnerTablePerConcreteClass("Bill", "Gates", 300L, 20L);
		owner.setPersonId(3L);
		session.save(owner);

		
		session.getTransaction().commit();
		session.close();

	}
}
