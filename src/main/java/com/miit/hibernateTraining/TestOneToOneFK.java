package com.miit.hibernateTraining;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestOneToOneFK {

	public static void main(String[] args) {
		Session session = null;

		try {
			SessionFactory sessionFactory = new Configuration().configure("hibernate-one-to-one.cfg.xml")
					.buildSessionFactory();
			session = sessionFactory.openSession();

			session.beginTransaction();
			Certificate certificate = new Certificate();
			certificate.setCertName("SCJP2");
			certificate.setCode("SCJP02"); //
			//session.save(certificate);
			Person person = new Person();
			person.setId(1);
			person.setCertificate(certificate);
			person.setName("Pinkesh");
			certificate.setPerson(person);
			session.save(person);
			session.getTransaction().commit();
		
			
			
			String SQL_QUERY = "from Person person";
			Query query = session.createQuery(SQL_QUERY);
			List<Object> userlist = query.list();
			for (Iterator iterator = userlist.iterator(); iterator.hasNext();) {
				Person obj = (Person) iterator.next();
				System.out.println("First Name: " + obj.getName());
				System.out.println("First Name: " + obj.getCertificate().getCertName());
			}

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			// Actual contact insertion will happen at this step
			System.out.println("test");
			session.close();
		}
	}

}
